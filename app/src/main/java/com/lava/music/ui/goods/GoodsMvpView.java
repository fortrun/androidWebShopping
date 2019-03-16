package com.lava.music.ui.goods;

import com.lava.music.data.network.model.GoodsResponse;
import com.lava.music.ui.base.MvpView;

public interface GoodsMvpView extends MvpView {

    void updateItem(GoodsResponse resp);

    void finishView();
}
