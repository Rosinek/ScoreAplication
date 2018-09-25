package com.example.rosinek.scoreapp.model.Api.RSS;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * Created by Grzegorz Rosinski on 25.09.2018.
 */

@Root(name = "item",strict = false)
public class NewsItem {

    @Element(name = "guid",required = false)
    private String guid;

    @Element(name = "title",required = false)
    private String title;

    @Element(name = "pubDate",required = false)
    private String pubDate;

    @Element(name = "enclosure",required = false)
    private Enclosure EnclosureObject;

    @Element(name = "description",required = false)
    private String description;

    @Element(name = "link",required = false)
    private String link;

    @Element(name = "category", required = false)
    @Path("category")
    @Text(required=false)
    private String category;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Enclosure getEnclosureObject() {
        return EnclosureObject;
    }

    public void setEnclosureObject(Enclosure enclosureObject) {
        EnclosureObject = enclosureObject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
