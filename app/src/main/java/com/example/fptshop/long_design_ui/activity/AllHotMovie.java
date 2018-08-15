package com.example.fptshop.long_design_ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fptshop.long_design_ui.R;

public class AllHotMovie extends AppCompatActivity{

    ImageView imgAllHotMovie;
    TextView tvAllHotMovie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_hot_movie);

        imgAllHotMovie = findViewById(R.id.imgAllHotMovie);
        tvAllHotMovie = findViewById(R.id.tvAllHotMovie);

    }
}
