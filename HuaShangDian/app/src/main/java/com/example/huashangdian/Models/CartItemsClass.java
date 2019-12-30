package com.example.huashangdian.Models;

public class CartItemsClass {

    private String name;
    private String price;
    private String description;

    public CartItemsClass(String name, String price, String description) {

        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void changetext(String text){
        name=text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }




}
