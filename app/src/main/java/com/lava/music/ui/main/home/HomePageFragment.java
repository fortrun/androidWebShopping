package com.lava.music.ui.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lava.music.R;
import com.lava.music.data.network.model.Banner;
import com.lava.music.di.component.ActivityComponent;
import com.lava.music.ui.base.BaseFragment;
import com.lava.music.ui.goods.GoodsDetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends BaseFragment implements HomePageMvpView {

    @BindView(R.id.banner_view)
    RecyclerView mBannerList;

    @BindView(R.id.channel_view)
    RecyclerView mChannel;

    @BindView(R.id.goods_list)
    RecyclerView mGoodsList;

    @BindView(R.id.hot_goods)
    RecyclerView mHotGoods;

    @BindView(R.id.brands)
    RecyclerView mBrands;
    @BindView(R.id.bland_title)
    TextView mBrandTitle;
    @Inject
    BrandAdapter mBrandAdapter;

    @Inject
    GridLayoutManager mListLayoutManager;

    @Inject
    BannerAdapter mBannerAdapter;

    @Inject
    ChannelAdapter mChannelAdapter;

    @Inject
    GoodsAdapter mGoodsAadapter;

    private GoodsAdapter HotAdapter;

    @Inject
    HomePageMvpPresenter<HomePageMvpView> mPresenter;

    public static HomePageFragment getInstance() {
        Bundle args = new Bundle();
        HomePageFragment instance = new HomePageFragment();
        instance.setArguments(args);
        return instance;
    }

    @Override
    protected void setUp(View view) {
        //banner ads
        mListLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mBannerAdapter.getItemCount();
            }
        });
        mBannerList.setLayoutManager(mListLayoutManager);
        mBannerList.setAdapter(mBannerAdapter);
        mListLayoutManager.setSmoothScrollbarEnabled(true);
        //-----------channel
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 5, GridLayoutManager.VERTICAL, false);
        mChannel.setAdapter(mChannelAdapter);
        mChannel.setLayoutManager(layoutManager);
        // ----------goods
        GridLayoutManager goodsLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        mGoodsList.setAdapter(mGoodsAadapter);
        mGoodsList.setLayoutManager(goodsLayoutManager);
        mGoodsAadapter.setView(this);
        // ---------hot goods
        GridLayoutManager hotGoodsManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        HotAdapter = new GoodsAdapter(new ArrayList<Banner.NewGoods>());
        mHotGoods.setAdapter(HotAdapter);
        mHotGoods.setLayoutManager(hotGoodsManager);
        // ------ brands
        //mBrandAdapter = new BrandAdapter(new ArrayList<Banner.Brand>());
        GridLayoutManager brandManager = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
        mBrandTitle.setVisibility(View.VISIBLE);
        mBrands.setAdapter(mBrandAdapter);
        mBrands.setLayoutManager(brandManager);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragmeng_home_page, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, homeView));
        }
        mPresenter.onAttach(this);
        setUp(homeView);
        mPresenter.onViewPrepared();
        mHandler.sendEmptyMessageDelayed(BANNER_EVENT_SCOLL, 100);
        return homeView;
    }

    @Override
    public void updateRepo(Banner.DataItems bannerItems) {
        mBannerAdapter.setData(bannerItems.getBanners());
        mChannelAdapter.setData(bannerItems.getChannels());
        mGoodsAadapter.setData(bannerItems.getNewGoodsList());
        HotAdapter.setData(bannerItems.getHotGoodsList());
        mBrandAdapter.setData(bannerItems.getBrandList());
    }

    private int mTimeCount = 0;
    private static final int INTERVAL = 5 * 1000;

    private static final int BANNER_EVENT_SCOLL = 1;
    private static final int BANNER_EVENT_STOP = 2;
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            switch (msg.what) {
                case BANNER_EVENT_SCOLL:
                    mListLayoutManager.smoothScrollToPosition(mBannerList, null, mTimeCount % 3);
                    mTimeCount++;
                    mHandler.sendEmptyMessageDelayed(BANNER_EVENT_SCOLL, INTERVAL);
                    break;
            }
        }
    };

    @Override
    public void onDetach() {
        super.onDetach();
        mHandler.removeMessages(BANNER_EVENT_SCOLL);
    }

    @Override
    public void viewGoods(String id) {

        Intent open = new Intent();
        open.putExtra(GoodsDetailActivity.GOODS_ID, id);
        open.setClass(getContext(), GoodsDetailActivity.class);
        startActivity(open);
    }
}
