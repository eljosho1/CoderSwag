package com.josh.coderswag.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private final String title;
    private final String price;
    private final String image;

    public Product(String title, String price, String image) {
        this.title = title;
        this.price = price;
        this.image = image;
    }

    protected Product(Parcel in) {
        title = in.readString();
        price = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(price);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

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
