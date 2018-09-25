package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "season", strict = false)
public class Season {

    @Element(name = "round" )
    Round round;

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }
}