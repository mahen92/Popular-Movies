package com.example.mahendran.moviecritic;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mahendran on 16-08-2016.
 */
public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private LayoutInflater inflater;
    ArrayList<String> imageUrls1;
    String[] images;

    public CustomAdapter(Context context, ArrayList<String> imageUrls) {
        super(context, R.layout.list_items, imageUrls);

        this.context=context;
        imageUrls1=imageUrls;

        inflater=LayoutInflater.from(context);


    }
    public long getItemId(int position)
    {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_items, parent, false);
        }
        if((imageUrls1.size()!=0)&&(imageUrls1!=null)) {
            images = imageUrls1.toArray(new String[imageUrls1.size()]);
            Picasso.with(context).load("http://image.tmdb.org/t/p/w185/"+images[position]).fit().into((ImageView) convertView);
        }

        return convertView;
    }
}
