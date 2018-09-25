package com.example.rosinek.scoreapp.ui.scores;

import com.example.rosinek.scoreapp.model.Api.GSMRS.GameMatch;
import com.example.rosinek.scoreapp.ui.BaseView;

import java.util.List;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
interface ScoresView extends BaseView{
    void onGetScores(List<GameMatch> scores);

    void updateDate(String result);
}
