package com.lava.music.ui.main.home;

import com.lava.music.ui.base.MvpPresenter;

public interface HomePageMvpPresenter<V extends HomePageMvpView>
        extends MvpPresenter<V> {
    void onViewPrepared();

}
