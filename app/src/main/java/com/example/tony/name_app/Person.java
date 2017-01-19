package com.example.tony.name_app;

import android.net.Uri;
import android.os.Parcelable;
import android.os.Parcel;


public class Person implements Parcelable {
    String name;
    Uri imgUri;
    int index;

    public Person() {

    }

    public Person(String name, Uri imgUri) {
        this.name = name;
        this.imgUri = imgUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Uri getImgURI() {
        return imgUri;
    }

    public void setImgURI(Uri imgURI) {
        this.imgUri = imgURI;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static final Parcelable.Creator<Person> CREATOR = new Creator<Person>() {
        public Person createFromParcel(Parcel source) {
            Person person = new Person();
            person.name = source.readString();
            person.imgUri = Uri.parse(source.readString());
            person.index = source.readInt();
            return person;

        }
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(imgUri.toString());
        parcel.writeInt(index);
    }

}
