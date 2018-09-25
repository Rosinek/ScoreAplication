package com.example.rosinek.scoreapp.ui.news;

import com.example.rosinek.scoreapp.model.Api.RSS.NewsItem;
import com.example.rosinek.scoreapp.ui.BaseView;

import java.util.ArrayList;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
interface NewsView extends BaseView {

    void showNews(ArrayList<NewsItem> news);

    void onItemSelected(int adapterPosition);
}
