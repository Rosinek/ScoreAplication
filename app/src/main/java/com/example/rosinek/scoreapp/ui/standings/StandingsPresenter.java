package com.example.rosinek.scoreapp.ui.standings;

import com.example.rosinek.scoreapp.api.ApiCallback;
import com.example.rosinek.scoreapp.api.ApiService;
import com.example.rosinek.scoreapp.model.Api.GSMRS.Gsmrs;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public class StandingsPresenter {

    private StandingsView view;
    private ApiService service;

    public StandingsPresenter(StandingsView view, ApiService service) {
        this.view = view;
        this.service = service;
    }

    public void getStandings(){
        service.getStandings().enqueue(new ApiCallback<Gsmrs>(view) {
            @Override
            public void onSuccess(Gsmrs result) {
                view.onGetRanking(result.getCompetition().getSeason().getRound().getResultstable().getRanking());
            }
        });

    }
}
