package com.lava.music.ui.main.home;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.lava.music.data.DataManager;
import com.lava.music.data.network.model.Banner;
import com.lava.music.ui.base.BasePresenter;
import com.lava.music.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class HomePagePresenter<V extends HomePageMvpView> extends BasePresenter<V>
        implements HomePageMvpPresenter<V> {

    private static final String TAG= "HomePagePresenter";

    @Inject
    public HomePagePresenter(DataManager dataManager,
                             SchedulerProvider schedulerProvider,
                             CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(
                getDataManager()
                        .getBannerApiCall()
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<Banner>() {
                            @Override
                            public void accept(@NonNull Banner banner) throws Exception{
                                if(banner != null && banner.getDataItems().getBanners() != null) {
                                    getMvpView().updateRepo(banner.getDataItems());
                                    Log.i(TAG, "query items " + banner.getDataItems().getBanners().size());
                                }
                                if(banner != null){
                                    Log.i(TAG, "Errors: " + banner.getError() +
                                    ", Errmsg" + banner.getErrmsg());
                                }
                                getMvpView().hideLoading();
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                if (!isViewAttached()) {
                                    return;
                                }
                                Log.i(TAG, "query items " ,throwable);
                                getMvpView().hideLoading();

                                // handle the error here
                                if (throwable instanceof ANError) {
                                    ANError anError = (ANError) throwable;
                                    handleApiError(anError);
                                }
                            }
                        })
        );
    }
}
