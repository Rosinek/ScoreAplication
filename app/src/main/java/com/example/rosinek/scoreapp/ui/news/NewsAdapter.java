package com.example.rosinek.scoreapp.ui.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rosinek.scoreapp.R;
import com.example.rosinek.scoreapp.model.Api.RSS.NewsItem;
import com.example.rosinek.scoreapp.utils.TimeUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<NewsItem> newsList;
    private NewsView view;
    private Context context;

    public NewsAdapter(List<NewsItem> newsList, NewsView view, Context context) {
        this.newsList = newsList;
        this.view = view;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NewsItem newsItem = newsList.get(position);

        holder.tvTitle.setText(newsItem.getTitle());

        holder.tvDate.setText(TimeUtils.getPreparedDate(newsItem.getPubDate(),"EEE, dd MMM yyyy HH:mm:ss Z"));

        setPhoto(holder.ivNews,newsItem);

    }

    @SuppressLint("CheckResult")
    private void setPhoto(ImageView ivNews, NewsItem newsItem) {
        Glide.with(context).load(newsItem.getEnclosureObject().getUrl()).into(ivNews);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.tv_date)
        TextView tvDate;

        @BindView(R.id.iv_news)
        ImageView ivNews;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.item_container)
            public void onItemClick(){
            view.onItemSelected(getAdapterPosition());
        }
    }
}
