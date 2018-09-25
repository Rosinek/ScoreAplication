package com.example.rosinek.scoreapp.api;

import com.example.rosinek.scoreapp.model.Api.GSMRS.Gsmrs;
import com.example.rosinek.scoreapp.model.Api.RSS.Rss;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public interface ApiService {

    @GET("latestnews.xml")
    Call<Rss> getNews();

    @GET("standings.xml")
    Call<Gsmrs> getStandings();

    @GET("scores.xml")
    Call<Gsmrs> getScores();

}
