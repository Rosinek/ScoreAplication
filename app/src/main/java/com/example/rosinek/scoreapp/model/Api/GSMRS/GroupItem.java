package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
@Root(name = "group", strict = false)
public class GroupItem {

    @ElementList(name = "match",inline = true)
    ArrayList<GameMatch> match = new ArrayList<>();

    public ArrayList<GameMatch> getMatch() {
        return match;
    }

    public void setMatch(ArrayList<GameMatch> match) {
        this.match = match;
    }
}
