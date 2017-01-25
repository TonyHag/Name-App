package com.example.tony.name_app;

import android.graphics.Bitmap;


public class Person {
    String name;
    int index;
    Bitmap bitmap;

    public Person() {

    }

    public Person(String name, Bitmap bitmap) {
        this.name = name;
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {return bitmap;}

    public void setBitmap(Bitmap bitmap) {this.bitmap = bitmap;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
