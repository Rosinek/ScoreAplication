package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
@Root(name = "ranking", strict = false)
public class RankingObject {

    @Attribute
    private String rank;

    @Attribute
    private String last_rank;

    @Attribute
    private String club_name;

    @Attribute
    private String matches_won;

    @Attribute
    private String matches_draw;

    @Attribute
    private String matches_lost;

    @Attribute
    private String goals_pro;

    @Attribute
    private String goals_against;

    @Attribute
    private String points;

    @Attribute
    private String matches_total;

    @Attribute(required = false)
    private String zone_start;

    public String getZone_start() {
        return zone_start;
    }

    public void setZone_start(String zone_start) {
        this.zone_start = zone_start;
    }



    public String getMatches_total() {
        return matches_total;
    }

    public void setMatches_total(String matches_total) {
        this.matches_total = matches_total;
    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLast_rank() {
        return last_rank;
    }

    public void setLast_rank(String last_rank) {
        this.last_rank = last_rank;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public String getMatches_won() {
        return matches_won;
    }

    public void setMatches_won(String matches_won) {
        this.matches_won = matches_won;
    }

    public String getMatches_draw() {
        return matches_draw;
    }

    public void setMatches_draw(String matches_draw) {
        this.matches_draw = matches_draw;
    }

    public String getMatches_lost() {
        return matches_lost;
    }

    public void setMatches_lost(String matches_lost) {
        this.matches_lost = matches_lost;
    }

    public String getGoals_pro() {
        return goals_pro;
    }

    public void setGoals_pro(String goals_pro) {
        this.goals_pro = goals_pro;
    }

    public String getGoals_against() {
        return goals_against;
    }

    public void setGoals_against(String goals_against) {
        this.goals_against = goals_against;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
