package com.example.mahendran.moviecritic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class onClickActivity extends AppCompatActivity {
    String builder;
    String[] splits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click);
        ImageView img = (ImageView) findViewById(R.id.clickImage);
        TextView desc = (TextView) findViewById(R.id.description);
        TextView date = (TextView) findViewById(R.id.date);
        TextView orig = (TextView) findViewById(R.id.original);
        TextView vote = (TextView) findViewById(R.id.vote);
        Intent intent=this.getIntent();
        if(intent!=null&&intent.hasExtra(Intent.EXTRA_TEXT))
        {

            builder=intent.getStringExtra(Intent.EXTRA_TEXT);
        }
        if(builder!=null) {
            splits = builder.split("&");
        }
        if(splits!=null) {
            if ((splits.length != 0) && (splits != null)) {
                for (String i : splits) {

                }

                Picasso.with(this).load("http://image.tmdb.org/t/p/w185/" + splits[0]).into(img);
                desc.setText(splits[1]);
                date.setText((splits[2]).split("-")[0]);
                vote.setText(splits[3]);
                orig.setText(splits[4]);
            }
        }

    }
}
