package com.raunits.animegirls.models;

public class Image {
    private int id;
    private String link;
    private String category;
    private String filename;

    public Image() {

    }

    public Image(String link, String category, String filename) {
        this.link = link;
        this.category = category;
        this.filename = filename;
    }

    public String getLink() {
        return this.link;
    }

    public String getCategory() {
        return this.category;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
