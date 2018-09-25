package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "gsmrs", strict = false)
public class Gsmrs {

    @Element(name = "method")
    private Method method;

    @Element(name = "competition")
    private Competition competition;

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
