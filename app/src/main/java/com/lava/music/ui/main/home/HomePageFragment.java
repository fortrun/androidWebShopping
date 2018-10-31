package com.lava.music.ui.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lava.music.R;
import com.lava.music.di.component.ActivityComponent;
import com.lava.music.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageFragment extends BaseFragment {

    @BindView(R.id.banner_view)
    RecyclerView mBannerList;

    @Inject
    GridLayoutManager mListLayoutManager;



    public static HomePageFragment getInstance() {
        Bundle args = new Bundle();
        HomePageFragment instance = new HomePageFragment();
        instance.setArguments(args);
        return instance;
    }

    @Override
    protected void setUp(View view) {
        mBannerList.setLayoutManager(mListLayoutManager);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragmeng_home_page,container, false);

        ActivityComponent component = getActivityComponent();
        if(component != null){
            component.inject(this);
            setUnBinder(ButterKnife.bind(this,homeView));

        }
        setUp(homeView);
        return homeView;
    }
}
