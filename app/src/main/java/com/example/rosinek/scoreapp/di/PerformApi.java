package com.example.rosinek.scoreapp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Grzegorz Rosinski on 03.08.2018.
 */
@Qualifier
@Retention(RetentionPolicy.CLASS)
public @interface PerformApi {
}