package com.example.sneakersshop;

public class PurchaseCard {
    String CardId;
    String Name;
    String Number;
    String Date;
    String CVV;


    public PurchaseCard(){

    }

    public PurchaseCard(String cardId, String name, String number, String date, String CVV) {
        CardId = cardId;
        Name = name;
        Number = number;
        Date = date;
        this.CVV = CVV;
    }

    public String getCardId() {
        return CardId;
    }

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Number;
    }

    public String getDate() {
        return Date;
    }

    public String getCVV() {
        return CVV;
    }
}
