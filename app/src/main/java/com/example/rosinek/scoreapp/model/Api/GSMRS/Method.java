package com.example.rosinek.scoreapp.model.Api.GSMRS;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "method", strict = false)
public class Method {

    @ElementList(name = "parameter",inline = true)
    ArrayList<ParameterItem> parameter = new ArrayList<>();

    public ArrayList<ParameterItem> getParameter() {
        return parameter;
    }

    public void setParameter(ArrayList<ParameterItem> parameter) {
        this.parameter = parameter;
    }
}