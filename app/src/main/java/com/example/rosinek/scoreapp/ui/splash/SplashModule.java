package com.example.rosinek.scoreapp.ui.splash;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Grzegorz Rosinski on 23.09.2018.
 */
@Module
public class SplashModule {

    @Provides
    SplashView provideSplashView(SplashActivity activity){
        return activity;
    }

    @Provides
    SplashNavigator provideSplashNavigator(SplashActivity activity){
        return activity;
    }

    @Provides
    SplashPresenter provideSplashPresenter(SplashView view, SplashNavigator navigator){
        return  new SplashPresenter(view, navigator);
    }
}
