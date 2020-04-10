package com.example.graduatework;

public class LinkList {

    public String link;
    public String short_link;

    public LinkList(String link, String short_link) {
        this.link = link;
        this.short_link = short_link;
    }

    public LinkList() {
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getShort_link() {
        return short_link;
    }

    public void setShort_link(String short_link) {
        this.short_link = short_link;
    }

    @Override
    public String toString() {
        return "LinkList{" +
                "link='" + link + '\'' +
                ", short_link='" + short_link + '\'' +
                '}';
    }
}
