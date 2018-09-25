package com.example.rosinek.scoreapp.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
public class TimeUtils {

    @SuppressLint("SimpleDateFormat")
    public static String getPreparedDate(String date, String inputFormat) {
        SimpleDateFormat input = new SimpleDateFormat(inputFormat);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MMM-dd");
        Date newDate = null;
        try {
            newDate = input.parse(date);
            return newFormat.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
