/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.lava.music.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.lava.music.di.ActivityContext;
import com.lava.music.di.PerActivity;
import com.lava.music.data.network.model.BlogResponse;
import com.lava.music.data.network.model.OpenSourceResponse;
import com.lava.music.ui.about.AboutMvpPresenter;
import com.lava.music.ui.about.AboutMvpView;
import com.lava.music.ui.about.AboutPresenter;
import com.lava.music.ui.feed.FeedMvpPresenter;
import com.lava.music.ui.feed.FeedMvpView;
import com.lava.music.ui.feed.FeedPagerAdapter;
import com.lava.music.ui.feed.FeedPresenter;
import com.lava.music.ui.feed.blogs.BlogAdapter;
import com.lava.music.ui.feed.blogs.BlogMvpPresenter;
import com.lava.music.ui.feed.blogs.BlogMvpView;
import com.lava.music.ui.feed.blogs.BlogPresenter;
import com.lava.music.ui.feed.opensource.OpenSourceAdapter;
import com.lava.music.ui.feed.opensource.OpenSourceMvpPresenter;
import com.lava.music.ui.feed.opensource.OpenSourceMvpView;
import com.lava.music.ui.feed.opensource.OpenSourcePresenter;
import com.lava.music.ui.login.LoginMvpPresenter;
import com.lava.music.ui.login.LoginMvpView;
import com.lava.music.ui.login.LoginPresenter;
import com.lava.music.ui.main.MainMvpPresenter;
import com.lava.music.ui.main.MainMvpView;
import com.lava.music.ui.main.MainPageAdapter;
import com.lava.music.ui.main.MainPresenter;
import com.lava.music.ui.main.rating.RatingDialogMvpPresenter;
import com.lava.music.ui.main.rating.RatingDialogMvpView;
import com.lava.music.ui.main.rating.RatingDialogPresenter;
import com.lava.music.ui.splash.SplashMvpPresenter;
import com.lava.music.ui.splash.SplashMvpView;
import com.lava.music.ui.splash.SplashPresenter;
import com.lava.music.utils.rx.AppSchedulerProvider;
import com.lava.music.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by janisharali on 27/01/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(
            MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    MainPageAdapter provideMainPageAdapter (AppCompatActivity activity) {
        return new MainPageAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    GridLayoutManager provideLinearGridLayoutManager(AppCompatActivity activity) {
        return new GridLayoutManager(activity ,3);
    }
}
