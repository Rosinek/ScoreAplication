package com.example.rosinek.scoreapp.ui.standings;

import com.example.rosinek.scoreapp.api.ApiService;
import com.example.rosinek.scoreapp.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Module
public class StandingsModule {

    @FragmentScope
    @Provides
    StandingsView provideStandingsView(StandingsFragment fragment){
        return fragment;
    }

    @FragmentScope
    @Provides
    StandingsPresenter provideStandingsPresenter(StandingsView view, ApiService service){
        return new StandingsPresenter(view, service);
    }

}
