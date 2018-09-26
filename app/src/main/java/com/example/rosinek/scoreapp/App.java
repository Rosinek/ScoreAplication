package com.example.rosinek.scoreapp;

import android.app.Activity;
import android.app.Application;

import com.example.rosinek.scoreapp.di.DaggerAppComponent;
import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.NoEncryption;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Grzegorz Rosinski on 23.09.2018.
 */
public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(getApplicationContext())
                .setEncryption(new NoEncryption())
                .build();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}

