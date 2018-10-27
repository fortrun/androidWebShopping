package com.lava.music.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lava.music.ui.feed.blogs.BlogFragment;
import com.lava.music.ui.feed.opensource.OpenSourceFragment;
import com.lava.music.ui.main.home.HomePageFragment;

public class MainPageAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public MainPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return HomePageFragment.getInstance();
            case 1:
                return OpenSourceFragment.newInstance();
            case 2:
                return OpenSourceFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }
}
