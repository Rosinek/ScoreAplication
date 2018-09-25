package com.example.rosinek.scoreapp.ui.main;

import com.example.rosinek.scoreapp.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
@Module
public class MainActivityModule {

    @ActivityScope
    @Provides
    MainActivityPresenter provideMainActivityPresenter(){
        return new MainActivityPresenter();
    }

}
