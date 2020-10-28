package com.josh.coderswag.Model;

public class Product {
    private final String title;
    private final String price;
    private final String image;

    public Product(String title, String price, String image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
