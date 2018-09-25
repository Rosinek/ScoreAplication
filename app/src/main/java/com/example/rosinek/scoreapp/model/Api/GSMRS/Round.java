package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "round", strict = false)
public class Round {

    @ElementList(name = "group", inline = true,required = false)
    ArrayList<GroupItem> group = new ArrayList<>();

    @Element(name = "resultstable",required = false)
    Resultstable resultstable;

    public ArrayList<GroupItem> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<GroupItem> group) {
        this.group = group;
    }

    public Resultstable getResultstable() {
        return resultstable;
    }

    public void setResultstable(Resultstable resultstable) {
        this.resultstable = resultstable;
    }
}