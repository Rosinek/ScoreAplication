package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "competition", strict = false)
public class Competition {

   @Element(name = "season" )
   private Season season;

   public Season getSeason() {
      return season;
   }

   public void setSeason(Season season) {
      this.season = season;
   }
}