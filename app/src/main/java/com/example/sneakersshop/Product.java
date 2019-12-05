package com.example.sneakersshop;

public class Product {
    String ProductId;
    String Description;
    String Price;
    String Stock;
    String Status;
    String Detail;

    public Product(){

    }

    public Product(String productId, String description, String price, String stock, String status, String detail) {
        ProductId = productId;
        Description = description;
        Price = price;
        Stock = stock;
        Status = status;
        Detail = detail;
    }

    public String getProductId() {
        return ProductId;
    }

    public String getDescription() {
        return Description;
    }

    public String getPrice() {
        return Price;
    }

    public String getStock() {
        return Stock;
    }

    public String getStatus() {
        return Status;
    }

    public String getDetail() {
        return Detail;
    }
}
