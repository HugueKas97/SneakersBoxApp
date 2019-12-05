package com.example.sneakersshop;

public class Shoes {
    String ShoeId;
    String Description;
    String Price;

    public Shoes(){

    }

    public Shoes(String shoeId, String description, String price) {
        ShoeId = shoeId;
        Description = description;
        Price = price;
    }

    public String getShoeId() {
        return ShoeId;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return Price;
    }
}
