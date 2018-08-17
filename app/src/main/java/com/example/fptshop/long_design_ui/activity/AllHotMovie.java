package com.example.fptshop.long_design_ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fptshop.long_design_ui.Adapter.AllHotMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Object.ObAllHotMovie;
import com.example.fptshop.long_design_ui.R;

import java.util.ArrayList;
import java.util.List;

public class AllHotMovie extends AppCompatActivity{

    Button btnBackFromAllHotMovie;
    private RecyclerView recyclerviewAllHotMovie;
    private ArrayList<ObAllHotMovie> lstAllHotMovie;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_hot_movie);

        btnBackFromAllHotMovie = findViewById(R.id.btnBackFromAllHotMovie);

        btnBackFromAllHotMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initAllHotMovie();
    }


    public void initAllHotMovie(){

        recyclerviewAllHotMovie = findViewById(R.id.recyclerviewAllHotMovie);
        recyclerviewAllHotMovie.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerviewAllHotMovie.setLayoutManager(staggeredGridLayoutManager);
        recyclerviewAllHotMovie.setItemAnimator(new DefaultItemAnimator());
        ArrayList<ObAllHotMovie> arrayList = new ArrayList<>();

        //ADD dữ liệu
        arrayList.add(new ObAllHotMovie(R.drawable.now1,"Cá mập siêu bạo chúa"));
        arrayList.add(new ObAllHotMovie(R.drawable.now2,"Nhiệm vụ bất khả thi:\nSụp đổ"));
        arrayList.add(new ObAllHotMovie(R.drawable.now3,"Christopher Robin"));
        arrayList.add(new ObAllHotMovie(R.drawable.now4, "Trí lực siêu phàm"));
        arrayList.add(new ObAllHotMovie(R.drawable.now5, "Bạn trai cũ tôi là \nđiệp viên"));
        arrayList.add(new ObAllHotMovie(R.drawable.now6, "Mirai: Em gái đến từ \ntương lai"));
        arrayList.add(new ObAllHotMovie(R.drawable.now7, "Gia đình là tất cả"));
        arrayList.add(new ObAllHotMovie(R.drawable.now8, "Avenger: Cuộc chiến \nvô cực"));
        arrayList.add(new ObAllHotMovie(R.drawable.now9, "Thế giới khủng long"));



        AllHotMovieRecyclerviewAdapter allHotMovieRecyclerviewAdapter = new AllHotMovieRecyclerviewAdapter(getApplicationContext(),arrayList);
        recyclerviewAllHotMovie.setAdapter(allHotMovieRecyclerviewAdapter);
    }


}
