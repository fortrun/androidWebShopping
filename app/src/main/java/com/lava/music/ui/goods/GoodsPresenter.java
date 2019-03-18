package com.lava.music.ui.goods;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.lava.music.data.DataManager;
import com.lava.music.data.network.model.GoodsResponse;
import com.lava.music.data.network.model.NideRequest;
import com.lava.music.ui.base.BasePresenter;
import com.lava.music.ui.base.MvpView;
import com.lava.music.utils.AppLogger;
import com.lava.music.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class GoodsPresenter<V extends GoodsMvpView> extends BasePresenter<V>
        implements GoodsMvpPresenter<V> {

    @Inject
    public GoodsPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared(String id) {
        //必须有商品id才能够查询商品信息，
        //而查询接口是固定的。***
        //查询id是通过 intent 传递给activity.所以界面打开后，将id传递到此presenter.
        NideRequest.GoodsRequest request = new NideRequest.GoodsRequest(id);
        getCompositeDisposable().add(getDataManager()
                .getGoodsPage(request)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<GoodsResponse>() {
                    @Override
                    public void accept(@NonNull GoodsResponse goodsResponse) throws Exception {
                        if (goodsResponse.getErrno() > 0) {
                            getMvpView().showMessage(goodsResponse.getErrmsg());
                            //getMvpView().onError(goodsResponse.getErrmsg());
                            getMvpView().finishView();
                            return;// for get goods info fail
                        }
                        getMvpView().updateItem(goodsResponse);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if(!isViewAttached()){
                            return;
                        }
                        Log.e("GoodsPresenter","get goods detail fail",throwable);
                        if(throwable instanceof ANError){
                            handleApiError((ANError)throwable);
                        }
                        getMvpView().finishView();
                    }
                }));
    }
}
