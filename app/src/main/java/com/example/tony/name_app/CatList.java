package com.example.tony.name_app;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

/**
 * Created by nataniel on 19.01.2017.
 */

public class CatList {

    private static ArrayList<Person> list;

    public static void initialize(Context context){
        list = new ArrayList<Person>();

        Bitmap bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.download);
        Bitmap bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.naty);
        Bitmap bitmap3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.tawny);

        Person cat1 = new Person("Runi", bitmap1);
        Person cat2 = new Person("Nati", bitmap2);
        Person cat3 = new Person("Toni", bitmap3);

        list.add(cat1);
        list.add(cat2);
        list.add(cat3);
    }

    public static Uri getUriToDrawable(Context context, int drawableId) {
        return Uri.parse(
                ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + context.getResources().getResourcePackageName(drawableId) +
                '/' + context.getResources().getResourceTypeName(drawableId) +
                '/' + context.getResources().getResourceEntryName(drawableId)
        );
    }


    public static ArrayList<Person> getList(){
        return list;
    }

    public static void addPersonToList(String name, Bitmap bitmap) {
        if(!name.isEmpty()) {
            list.add(new Person(name, bitmap));
        }
    }

    public static Bitmap findBitmapFromName(String name) {
        for (Person cat : list) {
            if (cat.getName().equals(name)) {
                return cat.getBitmap();
            }
        }
        return null;
    }

}
