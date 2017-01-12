package com.example.tony.name_app;

/**
 * Created by Tony on 12.01.2017.
 */

public class Person {
    String name;
    String imgURI;
    int index;

    public Person(String imgURI, String name, int index) {
        this.imgURI = imgURI;
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURI() {
        return imgURI;
    }

    public void setImgURI(String imgURI) {
        this.imgURI = imgURI;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
