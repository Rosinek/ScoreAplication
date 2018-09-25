package com.example.rosinek.scoreapp.model.Api.RSS;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */
@Root(name = "Rss")
public class Rss {

    @Element(name = "channel")
    private Channel ChannelObject;

    @Attribute
    private String version;


    public Channel getChannelObject() {
        return ChannelObject;
    }

    public void setChannelObject(Channel channelObject) {
        ChannelObject = channelObject;
    }

}
