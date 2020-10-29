package com.josh.coderswag.Model;

public class Category {
    private final String title;
    private final String image;

    public Category(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return title;
    }
}
