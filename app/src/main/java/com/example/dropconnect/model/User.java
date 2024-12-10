package com.example.dropconnect.model;

public class User {
    public String name;
    public String email;
    public String password;

    // Default constructor required for calls to DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String email,String password) {
        this.name = name;
        this.email = email;
        this.password=password;
    }
}