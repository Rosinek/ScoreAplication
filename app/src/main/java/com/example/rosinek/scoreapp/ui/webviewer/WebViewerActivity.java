package com.example.rosinek.scoreapp.ui.webviewer;

import android.annotation.SuppressLint;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rosinek.scoreapp.R;
import com.example.rosinek.scoreapp.utils.Preferences;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;

public class WebViewerActivity extends AppCompatActivity {

    private String link;

    @BindView(R.id.wv_news)
    WebView webView;

    @Inject
    WebViewerPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_viewer);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        link = getIntent().getStringExtra(Preferences.NEWS_LINK);
        initWebView();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        link = savedInstanceState.getString(Preferences.NEWS_LINK);
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setSupportZoom(true);
        webView.loadUrl(link);
    }

    @OnClick(R.id.btn_back)
    public void back(){
        onBackPressed();
    }
}
