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
            new Product("Devslopes Graphic Beanie", "$18", "hat1"),
            new Product("Devslopes Hat Black", "$20", "hat2"),
            new Product("Devslopes Hat White", "$18", "hat3"),
            new Product("Devslopes Hat Snapback", "22", "hat4"),
            new Product("Devslopes Graphic Beanie", "$18", "hat1"),
            new Product("Devslopes Hat Black", "$20", "hat2"),
            new Product("Devslopes Hat White", "$18", "hat3"),
            new Product("Devslopes Hat Snapback", "22", "hat4")
    );

    private final List<Product> hoodies = List.<Product>of(
            new Product("Devslopes Hoodie Gray", "$18", "hoodie1"),
            new Product("Devslopes Hoodie Red", "$32", "hoodie2"),
            new Product("Devslopes Hoodie Blue", "$18", "hoodie3"),
            new Product("Devslopes Hoodie Black", "$32", "hoodie4"),
            new Product("Devslopes Hoodie Gray", "$18", "hoodie1"),
            new Product("Devslopes Hoodie Red", "$32", "hoodie2"),
            new Product("Devslopes Hoodie Blue", "$18", "hoodie3"),
            new Product("Devslopes Hoodie Black", "$32", "hoodie4")
    );

    private final List<Product> shirts = List.<Product>of(
            new Product("Devslopes Shirt Gray", "$18", "shirt1"),
            new Product("Devslopes Logo Shirt", "$32", "shirt2"),
            new Product("Devslopes Shirt Blue", "$18", "shirt3"),
            new Product("Devslopes Hustle", "$32", "shirt4"),
            new Product("Kickflip Studios", "$18", "shirt5"),
            new Product("Devslopes Shirt Gray", "$18", "shirt1"),
            new Product("Devslopes Logo Shirt", "$32", "shirt2"),
            new Product("Devslopes Shirt Blue", "$18", "shirt3"),
            new Product("Devslopes Hustle", "$32", "shirt4"),
            new Product("Kickflip Studios", "$18", "shirt5")
    );

    private final List<Product> digitalGoods = List.<Product>of();

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

    public List<Product> getDigitalGoods() {
        return digitalGoods;
    }

    public List<Product> getProducts(String category){
        switch (category) {
            case "SHIRTS":
                return getShirts();
            case "HOODIES":
                return getHoodies();
            case "DIGITAL":
                return getDigitalGoods();
            case "HATS":
            default:
                return getHats();
        }
    }
}
