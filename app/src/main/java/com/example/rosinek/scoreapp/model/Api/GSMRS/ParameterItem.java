package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
@Root(name = "parameter")
public class ParameterItem {

    @Attribute
    private String name;
    @Attribute
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
