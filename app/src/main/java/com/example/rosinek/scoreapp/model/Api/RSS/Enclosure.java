package com.example.rosinek.scoreapp.model.Api.RSS;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "enclosure")
class Enclosure {

    @Attribute(name = "length",required = false)
    private String length;

    @Attribute(name = "url",required = false)
    private String url;

    @Attribute(name = "type",required = false)
    private String type;

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
