package com.example.rosinek.scoreapp.ui.scores;

import com.example.rosinek.scoreapp.api.ApiCallback;
import com.example.rosinek.scoreapp.api.ApiService;
import com.example.rosinek.scoreapp.model.Api.GSMRS.GameMatch;
import com.example.rosinek.scoreapp.model.Api.GSMRS.GroupItem;
import com.example.rosinek.scoreapp.model.Api.GSMRS.Gsmrs;
import com.example.rosinek.scoreapp.model.Api.GSMRS.ParameterItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public class ScoresPresenter {

    private ScoresView view;
    private ApiService service;
    private boolean dateIsFilled=false;
    private List<GameMatch> gameMatchList =new ArrayList<>();

    public ScoresPresenter(ScoresView view, ApiService service) {
        this.view = view;
        this.service = service;

    }

    public void getScores() {
        service.getScores().enqueue(new ApiCallback<Gsmrs>(view) {
            @Override
            public void onSuccess(Gsmrs result) {
                  getDateFromResult(result);
                  prepareListOfGames(result);
            }
        });
    }

    private void prepareListOfGames(Gsmrs result) {
        gameMatchList.clear();
        for(GroupItem item : result.getCompetition().getSeason().getRound().getGroup()){
            gameMatchList.addAll(item.getMatch());
        }
        view.onGetScores(gameMatchList);
    }

    private void getDateFromResult(Gsmrs result) {
        if(!dateIsFilled) {
            for (ParameterItem item : result.getMethod().getParameter()) {
                if (item.getName().equals("date")) {
                    dateIsFilled=true;
                    view.updateDate(item.getValue());
                }
            }
        }
    }


}
