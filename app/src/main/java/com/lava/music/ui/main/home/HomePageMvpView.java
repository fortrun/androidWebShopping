package com.lava.music.ui.main.home;

import com.lava.music.data.network.model.Banner;
import com.lava.music.ui.base.MvpView;

import java.util.List;

public interface HomePageMvpView extends MvpView {
    void updateRepo(Banner.DataItems bannerItems);

    void viewGoods(String id);
}
