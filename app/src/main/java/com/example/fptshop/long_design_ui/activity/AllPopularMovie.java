package com.example.fptshop.long_design_ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.example.fptshop.long_design_ui.adapter.AllPopularMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.object.ObAllPopularMovie;
import com.example.fptshop.long_design_ui.R;

import java.util.ArrayList;

public class AllPopularMovie extends AppCompatActivity {
    Button btnBackFromAllPopularMovie;
    private RecyclerView recyclerviewAllPopularMovie;
    private ArrayList<ObAllPopularMovie> lstAllHotMovie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_popular_movie);

        btnBackFromAllPopularMovie = findViewById(R.id.btnBackFromAllPopularMovie);

        btnBackFromAllPopularMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initAllPopularMovie();
    }


    public void initAllPopularMovie(){
        recyclerviewAllPopularMovie = findViewById(R.id.recyclerviewAllPopularMovie);
        recyclerviewAllPopularMovie.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerviewAllPopularMovie.setLayoutManager(staggeredGridLayoutManager);
        recyclerviewAllPopularMovie.setItemAnimator(new DefaultItemAnimator());
        ArrayList<ObAllPopularMovie> arrayList = new ArrayList<>();





        AllPopularMovieRecyclerviewAdapter allPopularMovieRecyclerviewAdapter = new AllPopularMovieRecyclerviewAdapter(getApplicationContext(),arrayList);
        recyclerviewAllPopularMovie.setAdapter(allPopularMovieRecyclerviewAdapter);

    }

}
