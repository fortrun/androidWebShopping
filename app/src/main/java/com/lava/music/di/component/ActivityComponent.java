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

package com.lava.music.di.component;

import com.lava.music.di.PerActivity;
import com.lava.music.di.module.ActivityModule;
import com.lava.music.di.PerActivity;
import com.lava.music.di.module.ActivityModule;
import com.lava.music.ui.about.AboutFragment;
import com.lava.music.ui.feed.FeedActivity;
import com.lava.music.ui.feed.blogs.BlogFragment;
import com.lava.music.ui.feed.opensource.OpenSourceFragment;
import com.lava.music.ui.login.LoginActivity;
import com.lava.music.ui.main.MainActivity;
import com.lava.music.ui.main.home.HomePageFragment;
import com.lava.music.ui.main.rating.RateUsDialog;
import com.lava.music.ui.splash.SplashActivity;
import com.lava.music.di.PerActivity;
import com.lava.music.di.module.ActivityModule;
import com.lava.music.ui.about.AboutFragment;
import com.lava.music.ui.feed.blogs.BlogFragment;
import com.lava.music.ui.feed.opensource.OpenSourceFragment;
import com.lava.music.ui.login.LoginActivity;
import com.lava.music.ui.main.MainActivity;
import com.lava.music.ui.main.rating.RateUsDialog;
import com.lava.music.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(FeedActivity activity);

    void inject(AboutFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogFragment fragment);

    void inject(RateUsDialog dialog);

    void inject(HomePageFragment fragment);
}
