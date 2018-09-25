package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "round", strict = false)
public class Resultstable {

    @ElementList(name = "ranking", inline = true, required = false)
    ArrayList<RankingObject> ranking = new ArrayList<>();

    public ArrayList<RankingObject> getRanking() {
        return ranking;
    }

    public void setRanking(ArrayList<RankingObject> ranking) {
        this.ranking = ranking;
    }

}
