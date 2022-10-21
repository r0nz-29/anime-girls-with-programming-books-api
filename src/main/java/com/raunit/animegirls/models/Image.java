package com.raunit.animegirls.models;

public class Image {
    private int id;
    private String link;
    private String category;

    public Image() {

    }

    public Image(String link, String category) {
        this.link = link;
        this.category = category;
    }

    public String getLink() {
        return this.link;
    }

    public String getCategory() {
        return this.category;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
