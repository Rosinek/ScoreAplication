package com.example.rosinek.scoreapp.di;

import com.example.rosinek.scoreapp.api.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Grzegorz Rosinski on 23.09.2018.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    ApiService provideApiService(@PerformApi Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
