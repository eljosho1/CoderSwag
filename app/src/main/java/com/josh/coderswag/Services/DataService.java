package com.josh.coderswag.Services;

import android.util.Log;

import com.josh.coderswag.Model.Category;
import com.josh.coderswag.Model.Product;

import java.util.List;

public class DataService {

    private static DataService dataService;

    private final List<Category> categories = List.<Category>of(
            new Category("SHIRTS", "shirtimage"),
            new Category("HOODIES", "hoodieimage"),
            new Category("HATS", "hatimage"),
            new Category("DIGITAL", "digitalgoodsimage"),
            new Category("SHIRTS", "shirtimage"),
            new Category("HOODIES", "hoodieimage"),
            new Category("HATS", "hatimage"),
            new Category("DIGITAL", "digitalgoodsimage"),
            new Category("SHIRTS", "shirtimage"),
            new Category("HOODIES", "hoodieimage"),
            new Category("HATS", "hatimage"),
            new Category("DIGITAL", "digitalgoodsimage"),
            new Category("SHIRTS", "shirtimage"),
            new Category("HOODIES", "hoodieimage"),
            new Category("HATS", "hatimage"),
            new Category("DIGITAL", "digitalgoodsimage")
    );

    private final List<Product> hats = List.<Product>of(
            new Product("Devslopes Graphic Beanie", "$18", "hat01"),
            new Product("Devslopes Hat Black", "$20", "hat02"),
            new Product("Devslopes Hat White", "$18", "hat03"),
            new Product("Devslopes Hat Snapback", "22", "hat04")
    );

    private final List<Product> hoodies = List.<Product>of(
            new Product("Devslopes Hoodie Gray", "$18", "hoodie01"),
            new Product("Devslopes Hoodie Red", "$32", "hoodie02"),
            new Product("Devslopes Hoodie Blue", "$18", "hoodie03"),
            new Product("Devslopes Hoodie Black", "$32", "hoodie04")
    );

    private final List<Product> shirts = List.<Product>of(
            new Product("Devslopes Shirt Gray", "$18", "shirt01"),
            new Product("Devslopes Logo Shirt", "$32", "shirt02"),
            new Product("Devslopes Shirt Blue", "$18", "shirt03"),
            new Product("Devslopes Hustle", "$32", "shirt04"),
            new Product("Kickflip Studios", "$18", "shirt05")
    );

    private DataService() {
    }

    public static DataService getDataService() {
        if (dataService == null){
            dataService = new DataService();
        }
        return dataService;
    }

    public List<Category> getCategories() {
        Log.d("DataService", "getCategories() " + categories.size());
        return categories;
    }

    public List<Product> getHats() {
        return hats;
    }

    public List<Product> getHoodies() {
        return hoodies;
    }

    public List<Product> getShirts() {
        return shirts;
    }
}
