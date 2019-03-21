package com.lava.music.ui.goods;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterViewFlipper;

import com.lava.music.R;
import com.lava.music.data.network.model.GoodsGallery;
import com.lava.music.data.network.model.GoodsResponse;
import com.lava.music.ui.base.BaseActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GoodsDetailActivity extends BaseActivity implements GoodsMvpView {

    public static final String GOODS_ID = "target_id";

    @Inject
    GoodsMvpPresenter<GoodsMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.top_pics)
    RecyclerView mTopPic;
    private TopAdapter fileAdapter;
    GridLayoutManager mListLayoutManager;

    private String mGoodsId = "";
    @Override
    protected void setUp() {
        mPresenter.onViewPrepared(mGoodsId);
    }

    @Override
    public void updateItem(GoodsResponse resp) {
        mToolbar.setTitle(resp.getGoodsData().getInfo().getName());
        fileAdapter.setData(resp.getGoodsData().getGallery());
        mListLayoutManager = new GridLayoutManager(this,resp.getGoodsData().getGallery().size()
        ,GridLayoutManager.HORIZONTAL, false);
        mListLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return fileAdapter.getItemCount();
            }
        });
        mTopPic.setLayoutManager(mListLayoutManager);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        getActivityComponent().inject(this);

        mGoodsId = "1181000";//getIntent().getStringExtra(GOODS_ID);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        fileAdapter = new TopAdapter(new ArrayList<GoodsGallery>());
        mTopPic.setAdapter(fileAdapter);
        setUp();
    }

    @Override
    public void finishView() {
        finish();
    }
}
