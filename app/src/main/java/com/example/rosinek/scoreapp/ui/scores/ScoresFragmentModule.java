package com.example.rosinek.scoreapp.ui.scores;

import com.example.rosinek.scoreapp.api.ApiService;
import com.example.rosinek.scoreapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Module
public class ScoresFragmentModule {


    @FragmentScope
    @Provides
    ScoresView provideScoresView(ScoresFragment fragment){
        return fragment;
    }

    @FragmentScope
    @Provides
    ScoresPresenter provideScoresPresenter(ApiService service, ScoresView view){
        return new ScoresPresenter(view, service);
    }

}
