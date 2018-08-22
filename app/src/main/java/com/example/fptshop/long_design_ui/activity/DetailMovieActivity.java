package com.example.fptshop.long_design_ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fptshop.long_design_ui.R;

public class DetailMovieActivity extends AppCompatActivity {
    ImageView imgDetailMovie;
    Button btnBackFromAllDetailMovie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        imgDetailMovie = findViewById(R.id.imgDetailMovie);
        btnBackFromAllDetailMovie = findViewById(R.id.btnBackFromAllDetailMovie);

        btnBackFromAllDetailMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
