package com.example.rosinek.scoreapp.ui.scores;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rosinek.scoreapp.R;
import com.example.rosinek.scoreapp.model.Api.GSMRS.GameMatch;
import com.example.rosinek.scoreapp.utils.TimeUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

public class ScoresFragment extends Fragment implements ScoresView {

    private Handler handler;
    private Runnable runnable;

    @BindView(R.id.tv_date)
    TextView tvDate;

    @BindView(R.id.rv_scores)
    RecyclerView rvScores;

    @Inject
    ScoresPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_scores, container, false);
        ButterKnife.bind(this, view);
        AndroidSupportInjection.inject(this);
        initScoresRecyclerView();
        return view;
    }


    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        handler = new Handler();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetScores(List<GameMatch> scores) {
        ScoresAdapter adapter = new ScoresAdapter(scores, getActivity());
        rvScores.setAdapter(adapter);
        setAutoRefresh();
    }


    @Override
    public void updateDate(String result) {
        tvDate.setText(TimeUtils.getPreparedDate(result,"yyyy-MM-dd"));
    }

    private void initScoresRecyclerView() {
        rvScores.setHasFixedSize(true);
        rvScores.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.getScores();
    }

    private void setAutoRefresh() {
        handler.postDelayed(runnable = () ->
                presenter.getScores(), 8000);
    }

}
