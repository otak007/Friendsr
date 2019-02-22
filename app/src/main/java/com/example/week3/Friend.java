package com.example.week3;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;

    //constructor
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }
    // getter for the name
    public String getName(){
        return this.name;
    }
    // getter for the bio
    public String getBio() {
        return this.bio;
    }
    // getter for the id
    public int getDrawableId() {
        return this.drawableId;
    }
    // setter for the rating
    public void setRating(float rating) {
        this.rating = rating;
    }
}
