package com.lava.music.ui.goods;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lava.music.R;
import com.lava.music.data.network.model.GoodsResponse;
import com.lava.music.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

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
        setContentView(R.layout.activity_goods_detail);
        getActivityComponent().inject(this);

        mGoodsId = getIntent().getStringExtra(GOODS_ID);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    public void finishView() {
        finish();
    }
}
