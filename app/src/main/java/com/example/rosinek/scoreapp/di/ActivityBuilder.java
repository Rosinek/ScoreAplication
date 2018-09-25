package com.example.rosinek.scoreapp.di;

import com.example.rosinek.scoreapp.ui.login.LoginActivity;
import com.example.rosinek.scoreapp.ui.login.LoginModule;
import com.example.rosinek.scoreapp.ui.main.MainActivity;
import com.example.rosinek.scoreapp.ui.main.MainActivityBuilder;
import com.example.rosinek.scoreapp.ui.main.MainActivityModule;
import com.example.rosinek.scoreapp.ui.splash.SplashActivity;
import com.example.rosinek.scoreapp.ui.splash.SplashModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 *Created by Grzegorz Rosinski on 23.09.2018.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity bindLoginActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class, MainActivityBuilder.class})
    abstract MainActivity bindMainActivity();

}
