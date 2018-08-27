package com.example.fptshop.long_design_ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fptshop.long_design_ui.Adapter.CastMovieAdapter;
import com.example.fptshop.long_design_ui.Object.ObCast;
import com.example.fptshop.long_design_ui.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailMovieActivity extends AppCompatActivity {

    List<ObCast> lstCast = new ArrayList<>();
    ImageView imgImageDetail;
    Button btnBackFromAllDetailMovie;
    RecyclerView recylerviewCast;
    TextView tvIntroduce;
    String LinkImage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);


        btnBackFromAllDetailMovie = findViewById(R.id.btnBackFromAllDetailMovie);
        imgImageDetail = findViewById(R.id.imgImageDetail);
        tvIntroduce = findViewById(R.id.tvIntroduce);
        recylerviewCast = findViewById(R.id.recylerviewCast);

        btnBackFromAllDetailMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Intent intent = getIntent();
        LinkImage = intent.getStringExtra("IMAGE");




        Picasso.with(getApplicationContext())
                .load(LinkImage)
                .resize(1080, 1480)
                .into(imgImageDetail);

        tvIntroduce.setText(intent.getStringExtra("NAME"));

        CastMovieAdapter castMovieAdapter = new CastMovieAdapter(getApplicationContext(), lstCast);
        LinearLayoutManager castLayoutManager = new LinearLayoutManager(getApplicationContext());
        castLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recylerviewCast.setNestedScrollingEnabled(false);
        recylerviewCast.setLayoutManager(castLayoutManager);

        lstCast.add(new ObCast(R.drawable.chrisevans, "Chris Evans"));
        lstCast.add(new ObCast(R.drawable.chrisevans, "Chris Evans"));
        lstCast.add(new ObCast(R.drawable.chrisevans, "Chris Evans"));
        lstCast.add(new ObCast(R.drawable.chrisevans, "Chris Evans"));
        lstCast.add(new ObCast(R.drawable.chrisevans, "Chris Evans"));
        lstCast.add(new ObCast(R.drawable.chrisevans, "Chris Evans"));
        lstCast.add(new ObCast(R.drawable.chrisevans, "Chris Evans"));
        lstCast.add(new ObCast(R.drawable.chrisevans, "Chris Evans"));

        recylerviewCast.setAdapter(castMovieAdapter);


    }
}
