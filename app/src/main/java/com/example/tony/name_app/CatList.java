package com.example.tony.name_app;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by nataniel on 19.01.2017.
 */

public class CatList {

    private static ArrayList<Person> list;

    public static void initialize(Context context){
        list = new ArrayList<Person>();

        Person cat1 = new Person("Runi", getUriToDrawable(context, R.drawable.download), null);
        Person cat2 = new Person("Nati", getUriToDrawable(context, R.drawable.naty),null);
        Person cat3 = new Person("Toni", getUriToDrawable(context, R.drawable.tawny),null);

       /** list.add(cat1);
        list.add(cat2);
        list.add(cat3);**/
    }

    public static Uri getUriToDrawable(Context context, int drawableId) {
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + context.getResources().getResourcePackageName(drawableId)
                + '/' + context.getResources().getResourceTypeName(drawableId)
                + '/' + context.getResources().getResourceEntryName(drawableId)
        );
    }


    public static ArrayList<Person> getList(){
        return list;
    }

    public static void addPersonToList(String name, Uri uri, Bitmap bitmap){
        if(!name.isEmpty()/** && !uri.equals(null) || !bitmap.equals(null))**/ ) {
            list.add(new Person(name, uri, bitmap));
        }
    }

    public static Uri findUriFromName(String name){
        for (Person cat : list) {
            if (cat.getName().equals(name)) {
                return cat.getImgURI();
            }
        }
        
        return null;
    }
    public static  Bitmap findBitmapFromName(String name){
        for (Person cat : list) {
            if (cat.getName().equals(name)) {
                return cat.getBitmap();
            }
        }
        return null;
    }

}
