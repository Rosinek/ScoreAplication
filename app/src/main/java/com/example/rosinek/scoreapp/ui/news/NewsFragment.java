package com.example.rosinek.scoreapp.ui.news;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rosinek.scoreapp.R;
import com.example.rosinek.scoreapp.model.Api.RSS.NewsItem;
import com.example.rosinek.scoreapp.ui.webviewer.WebViewerActivity;
import com.example.rosinek.scoreapp.utils.Preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;


public class NewsFragment extends Fragment implements NewsView {

    private List<NewsItem> newsItems = new ArrayList<>();

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @Inject
    NewsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        AndroidSupportInjection.inject(this);
        initRecyclerView();
        return view;
    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNews(ArrayList<NewsItem> news) {
        newsItems = news;
        NewsAdapter adapter = new NewsAdapter(news, this, getActivity());
        rvNews.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(int adapterPosition) {

        Intent intent = new Intent(getActivity(), WebViewerActivity.class);
        intent.putExtra(Preferences.NEWS_LINK, newsItems.get(adapterPosition).getLink());

        Objects.requireNonNull(getActivity()).startActivity(intent);
    }

    private void initRecyclerView() {
        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
