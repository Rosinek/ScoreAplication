package com.example.rosinek.scoreapp.ui.main;

import com.example.rosinek.scoreapp.di.FragmentScope;
import com.example.rosinek.scoreapp.ui.news.NewsFragment;
import com.example.rosinek.scoreapp.ui.news.NewsFragmentModule;
import com.example.rosinek.scoreapp.ui.scores.ScoresFragment;
import com.example.rosinek.scoreapp.ui.scores.ScoresFragmentModule;
import com.example.rosinek.scoreapp.ui.standings.StandingsFragment;
import com.example.rosinek.scoreapp.ui.standings.StandingsModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
@Module
public abstract class MainActivityBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = NewsFragmentModule.class)
    abstract NewsFragment bindNewsFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = ScoresFragmentModule.class)
    abstract ScoresFragment bindScoresFragment();

    @FragmentScope
    @ContributesAndroidInjector(modules = StandingsModule.class)
    abstract StandingsFragment bindStandingsFragment();

}