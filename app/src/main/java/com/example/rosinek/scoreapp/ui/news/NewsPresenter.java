package com.example.rosinek.scoreapp.ui.news;

import android.util.Log;

import com.example.rosinek.scoreapp.api.ApiCallback;
import com.example.rosinek.scoreapp.api.ApiService;
import com.example.rosinek.scoreapp.model.Api.RSS.Rss;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public class NewsPresenter {

    private ApiService service;
    private NewsView view;

    public NewsPresenter(ApiService service, NewsView view) {
        this.service = service;
        this.view = view;
        getNews();
    }

    public void getNews() {
        service.getNews().enqueue(new ApiCallback<Rss>(view) {
            @Override
            public void onSuccess(Rss result) {
                Log.d("News", "onSuccess: " + result.getChannelObject().getTitle());
                view.showNews(result.getChannelObject().getNewsItem());
            }
        });
    }


}
