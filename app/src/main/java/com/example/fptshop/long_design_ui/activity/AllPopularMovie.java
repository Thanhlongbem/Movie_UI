package com.example.fptshop.long_design_ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.example.fptshop.long_design_ui.Adapter.AllPopularMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Object.ObAllPopularMovie;
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

        //ADD dữ liệu
        arrayList.add(new ObAllPopularMovie(R.drawable.pp1, "Tòa tháp trọc trời"));
        arrayList.add(new ObAllPopularMovie(R.drawable.pp2, "ET Cậu bé ngoài \nhành tinh"));
        arrayList.add(new ObAllPopularMovie(R.drawable.pp3, "Trùm bài"));
        arrayList.add(new ObAllPopularMovie(R.drawable.pp4, "Trừng phạt tội ác"));
        arrayList.add(new ObAllPopularMovie(R.drawable.pp5, "Trả thù"));
        arrayList.add(new ObAllPopularMovie(R.drawable.pp6, "Tiên tri ngày tận thế"));



        AllPopularMovieRecyclerviewAdapter allPopularMovieRecyclerviewAdapter = new AllPopularMovieRecyclerviewAdapter(getApplicationContext(),arrayList);
        recyclerviewAllPopularMovie.setAdapter(allPopularMovieRecyclerviewAdapter);

    }

}
