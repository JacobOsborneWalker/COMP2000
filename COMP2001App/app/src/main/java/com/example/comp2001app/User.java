package com.example.comp2001app;

public class User {
    private String name;
    private int imageResId;

    public User(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
