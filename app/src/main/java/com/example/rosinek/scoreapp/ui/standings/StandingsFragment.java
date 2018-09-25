package com.example.rosinek.scoreapp.ui.standings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rosinek.scoreapp.R;
import com.example.rosinek.scoreapp.model.Api.GSMRS.RankingObject;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class StandingsFragment extends Fragment implements StandingsView {

    @BindView(R.id.rv_standings)
    RecyclerView rvStandings;

    @Inject
    StandingsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_standings, container, false);
        ButterKnife.bind(this,view);
        AndroidSupportInjection.inject(this);
        initRecyclerView();
        return view;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void initRecyclerView() {
        rvStandings.setHasFixedSize(true);
        rvStandings.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.getStandings();
    }

    @Override
    public void onGetRanking(ArrayList<RankingObject> ranking) {
        StandingsAdapter adapter = new StandingsAdapter(ranking, getActivity());
        rvStandings.setAdapter(adapter);
    }
}
