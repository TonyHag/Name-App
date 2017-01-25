package com.example.tony.name_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;



public class ImageAdapter extends ArrayAdapter<Person> {
    private Context context;

    public ImageAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.single_image, parent, false);

            holder = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);
        } else {
            holder = (ImageView) convertView.getTag();
        }

        Person item = getItem(position);
        if (item != null) {
            holder.setImageBitmap(item.getBitmap());
            return convertView;
        }

        return convertView;
    }
}
