package com.example.fptshop.long_design_ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fptshop.long_design_ui.R;
import com.squareup.picasso.Picasso;

public class DetailMovieActivity extends AppCompatActivity {
    ImageView imgDetailMovie;
    Button btnBackFromAllDetailMovie;
    Button btnPlay;
    TextView tvIntroduce;
    String LinkImage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        imgDetailMovie = findViewById(R.id.imgDetailMovie);
        btnBackFromAllDetailMovie = findViewById(R.id.btnBackFromAllDetailMovie);
        btnPlay = findViewById(R.id.btnPlay);
        tvIntroduce = findViewById(R.id.tvMovieDetail);





        btnBackFromAllDetailMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        LinkImage = intent.getStringExtra("IMAGE");
        tvIntroduce.setText(intent.getStringExtra("NAME"));
        //tvIntroduce.setText("alnfskjssnjsflnfs");

        Context mContext = getApplicationContext();
        Picasso.with(mContext)
                .load(LinkImage)
                .into(imgDetailMovie);

    }
}
