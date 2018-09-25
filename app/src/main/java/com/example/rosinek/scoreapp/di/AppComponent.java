package com.example.rosinek.scoreapp.di;

import android.app.Application;

import com.example.rosinek.scoreapp.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Grzegorz Rosinski on 23.09.2018.
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ApiModule.class,
        ActivityBuilder.class})

public interface AppComponent {

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}