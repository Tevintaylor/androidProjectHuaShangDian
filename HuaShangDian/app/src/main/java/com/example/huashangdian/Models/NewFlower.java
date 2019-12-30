package com.example.huashangdian.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class NewFlower implements Parcelable {

    private String NewFlowersName;
    private int NewFlowersimage;
    private String NewFlowersDescription;
    private String NewFlowerUrl;



    public NewFlower(String NewFlowersName, int NewFlowersimage, String NewFlowersDescription,String NewFlowerUrl) {
        this.NewFlowersName = NewFlowersName;
        this.NewFlowersimage = NewFlowersimage;
        this.NewFlowersDescription = NewFlowersDescription;
        this.NewFlowerUrl = NewFlowerUrl;
    }

    public NewFlower(NewFlower product) {
        this.NewFlowersName = product.NewFlowersName;
        this.NewFlowersimage = product.NewFlowersimage;
        this.NewFlowersDescription = product.NewFlowersDescription;
        this.NewFlowerUrl = product.NewFlowerUrl;
    }

    protected NewFlower(Parcel in) {
        NewFlowersName = in.readString();
        NewFlowersimage = in.readInt();
        NewFlowersDescription = in.readString();
    }



    public static final Parcelable.Creator<Flower> CREATOR = new Parcelable.Creator<Flower>() {
        @Override
        public Flower createFromParcel(Parcel in) {
            return new Flower(in);
        }

        @Override
        public Flower[] newArray(int size) {
            return new Flower[size];
        }
    };

    public String getUrl() {
        return NewFlowerUrl;
    }

    public void setUrl(String url) {
        NewFlowerUrl = url;
    }

    public String getName() {
        return NewFlowersName;
    }

    public int getImage() {
        return NewFlowersimage;
    }

    public String getDescription() {
        return NewFlowersDescription;
    }

    public void setName(String name) {
        this.NewFlowersName = name;
    }

    public void setImage(int image) {
        this.NewFlowersimage = image;
    }

    public void setDescription(String description) {
        NewFlowersDescription = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(NewFlowersName);
        parcel.writeInt(NewFlowersimage);
        parcel.writeString(NewFlowersDescription);
        parcel.writeString(NewFlowerUrl);
    }

}

