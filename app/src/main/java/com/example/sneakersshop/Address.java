package com.example.sneakersshop;

public class Address {
    String AddressId;
    String Name;
    String Address;
    String Reference;

    public Address(){

    }

    public Address(String addressId, String name, String address, String reference) {
        AddressId = addressId;
        Name = name;
        Address = address;
        Reference = reference;
    }

    public String getAddressId() {
        return AddressId;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getReference() {
        return Reference;
    }
}
