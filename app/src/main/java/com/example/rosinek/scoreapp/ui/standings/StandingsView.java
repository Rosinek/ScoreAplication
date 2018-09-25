package com.example.rosinek.scoreapp.ui.standings;

import com.example.rosinek.scoreapp.model.Api.GSMRS.RankingObject;
import com.example.rosinek.scoreapp.ui.BaseView;

import java.util.ArrayList;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
interface StandingsView extends BaseView{
    void onGetRanking(ArrayList<RankingObject> ranking);
}
