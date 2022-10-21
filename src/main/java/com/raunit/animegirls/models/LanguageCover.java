package com.raunit.animegirls.models;

public class LanguageCover extends Language {
    public ImageDetails image;

    public LanguageCover(String name, ImageDetails image) {
        super(name, name);
        this.image = image;
    }
}
