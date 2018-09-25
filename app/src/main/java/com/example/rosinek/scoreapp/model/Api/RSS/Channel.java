package com.example.rosinek.scoreapp.model.Api.RSS;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "channel", strict = false)
public class Channel {

    @Element(name = "title")
    private String title;

    @Element(name = "description", required = false)
    private String description;

    @Element(name = "language")
    private String language;

    @Element(name = "pubDate")
    private String pubDate;

    @Element(name = "link")
    private String link;

    @ElementList(name = "item", inline = true)
    private ArrayList<NewsItem> newsItem = new ArrayList<>();

//    @ElementList(inline=true, entry="resource")
//    ArrayList < Object > category = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ArrayList<NewsItem> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(ArrayList<NewsItem> newsItem) {
        this.newsItem = newsItem;
    }
}
