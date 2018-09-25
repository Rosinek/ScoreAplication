package com.example.rosinek.scoreapp.ui.news;

import com.example.rosinek.scoreapp.api.ApiService;
import com.example.rosinek.scoreapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Module
public class NewsFragmentModule {

    @FragmentScope
    @Provides
    NewsView provideNewsView(NewsFragment fragment){
        return fragment;
    }

    @FragmentScope
    @Provides
    NewsPresenter provideNewsPresenter(ApiService service, NewsView view){
        return new NewsPresenter(service,view);
    }
}
