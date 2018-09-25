package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */


@Root(name = "match", strict = false)
public class GameMatch {

    @Attribute(name = "team_A_name")
    private String team_A_name;

    @Attribute(name = "team_B_name")
    private String team_B_name;

    @Attribute(name = "fs_A")
    private String fs_A;

    @Attribute(name = "fs_B")
    private String fs_B;

    public String getTeam_A_name() {
        return team_A_name;
    }

    public void setTeam_A_name(String team_A_name) {
        this.team_A_name = team_A_name;
    }

    public String getTeam_B_name() {
        return team_B_name;
    }

    public void setTeam_B_name(String team_B_name) {
        this.team_B_name = team_B_name;
    }

    public String getFs_A() {
        return fs_A;
    }

    public void setFs_A(String fs_A) {
        this.fs_A = fs_A;
    }

    public String getFs_B() {
        return fs_B;
    }

    public void setFs_B(String fs_B) {
        this.fs_B = fs_B;
    }
}
