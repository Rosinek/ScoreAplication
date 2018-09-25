package com.example.rosinek.scoreapp.di;

import android.app.Application;
import android.content.Context;

import com.example.rosinek.scoreapp.utils.Constants;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


/**
 * Created by Grzegorz Rosinski on 23.09.2018.
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @PerformApi
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(Constants.INSTANCE.getBASE_URL());
        builder.client(new OkHttpClient());
        builder.addConverterFactory(SimpleXmlConverterFactory.create());
        return builder.build();
    }


}
