package com.lava.music.ui.goods;

import com.lava.music.ui.base.MvpPresenter;
import com.lava.music.ui.base.MvpView;

public interface GoodsMvpPresenter<V extends MvpView> extends MvpPresenter<V> {

    void onViewPrepared(String id);
}
