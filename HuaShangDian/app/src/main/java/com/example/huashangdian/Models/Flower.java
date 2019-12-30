package com.example.huashangdian.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

public class Flower implements Parcelable {

    private String name;
    private int image;
    private BigDecimal price;
    private String Description;


    public Flower(String name, int image, BigDecimal price, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.Description = description;
    }

    public Flower(Flower product) {
        this.name = product.name;
        this.image = product.image;
        this.price = product.price;
        this.Description = product.Description;
    }

    protected Flower(Parcel in) {
        name = in.readString();
        image = in.readInt();
        Description = in.readString();
    }



    public static final Creator<Flower> CREATOR = new Creator<Flower>() {
        @Override
        public Flower createFromParcel(Parcel in) {
            return new Flower(in);
        }

        @Override
        public Flower[] newArray(int size) {
            return new Flower[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return Description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(image);
        parcel.writeString(Description);
    }
}
