package com.example.sneakersshop;

public class UserClient {
    String UserClientId;
    String Name;
    String Email;
    String Pssword;


    public UserClient(){

    }

    public UserClient(String userClientId, String name, String email, String pssword) {
        UserClientId = userClientId;
        Name = name;
        Email = email;
        Pssword = pssword;
    }

    public String getUserClientId() {
        return UserClientId;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPssword() {
        return Pssword;
    }
}
