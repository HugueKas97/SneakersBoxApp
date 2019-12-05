package com.example.sneakersshop;

public class Order {
    String OrderId;
    String Mail;
    String Address;
    String Number;
    String CVV;
    String Item;
    String ItemSize;

    public Order(){

    }

    public Order(String orderId, String mail, String address, String number, String CVV, String item, String itemsize) {
        OrderId = orderId;
        Mail = mail;
        Address = address;
        Number = number;
        this.CVV = CVV;
        Item = item;
        ItemSize = itemsize;
    }

    public String getOrderId() {
        return OrderId;
    }

    public String getMail() {
        return Mail;
    }

    public String getAddress() {
        return Address;
    }

    public String getNumber() {
        return Number;
    }

    public String getCVV() {
        return CVV;
    }

    public String getItem() {
        return Item;
    }

    public String getItemSize() {
        return ItemSize;
    }
}
