package com.lava.music.ui.goods;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lava.music.data.network.model.GoodsResponse;
import com.lava.music.ui.base.BaseActivity;

import javax.inject.Inject;

public class GoodsDetailActivity extends BaseActivity implements GoodsMvpView {

    public static final String GOODS_ID = "target_id";
    @Inject
    GoodsMvpPresenter<GoodsMvpView> mPresenter;

    private String mGoodsId = "";
    @Override
    protected void setUp() {
        mPresenter.onViewPrepared(mGoodsId);
    }

    @Override
    public void updateItem(GoodsResponse resp) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGoodsId = getIntent().getStringExtra(GOODS_ID);
        setUp();
    }

    @Override
    public void finishView() {
        finish();
    }
}
