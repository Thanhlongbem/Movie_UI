package com.example.fptshop.long_design_ui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fptshop.long_design_ui.Adapter.NewFeedMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Adapter.HotMovieMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Adapter.PopularMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Object.ObMovieHotMovie;
import com.example.fptshop.long_design_ui.Object.ObMovieNewFeed;
import com.example.fptshop.long_design_ui.Object.ObMoviePopular;
import com.example.fptshop.long_design_ui.R;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class FragmentMovie extends Fragment {
    Realm realm;
    View v,v1;
    private RecyclerView newFeedRecyclerview;
    private RecyclerView nowRecyvlerview;
    private RecyclerView popularRecyvlerview;
    private List<ObMovieNewFeed> lstObMovieNewFeed;
    private List<ObMovieHotMovie> lstObMovieHotMovie;
    private List<ObMoviePopular> lstObMoviePopular;

    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;


    public FragmentMovie(){}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.movie_fragment,container,false);
        toolbar =  v.findViewById(R.id.toolbar);
        collapsingToolbarLayout = v.findViewById(R.id.collapsing_toolbar);
        //Recyclerview 1----------------------------------------------------------------------------
        newFeedRecyclerview = (RecyclerView)v.findViewById(R.id.recyclerviewNewFeed);

        //Scroll View
        newFeedRecyclerview.setNestedScrollingEnabled(false);

        NewFeedMovieRecyclerviewAdapter newFeedadapter = new NewFeedMovieRecyclerviewAdapter(getContext(),lstObMovieNewFeed);
        LinearLayoutManager newFeedLayoutManager = new LinearLayoutManager(getActivity());
        newFeedLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        newFeedRecyclerview.setLayoutManager(newFeedLayoutManager);
        Context context = getContext();
        newFeedRecyclerview.setAdapter(newFeedadapter);


        //Recyclerview 2----------------------------------------------------------------------------
        nowRecyvlerview = (RecyclerView)v.findViewById(R.id.recyclerviewNow);
        //Scroll View
        nowRecyvlerview.setNestedScrollingEnabled(false);

        HotMovieMovieRecyclerviewAdapter nowAdapter = new HotMovieMovieRecyclerviewAdapter(getContext(), lstObMovieHotMovie);
        LinearLayoutManager nowLayoutManager = new LinearLayoutManager(getActivity());
        nowLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        nowRecyvlerview.setLayoutManager(nowLayoutManager);
        nowRecyvlerview.setAdapter(nowAdapter);


        //Recyclerview 3----------------------------------------------------------------------------
        popularRecyvlerview = (RecyclerView)v.findViewById(R.id.recyclerviewPopular);
        //Scroll View
        popularRecyvlerview.setNestedScrollingEnabled(false);

        PopularMovieRecyclerviewAdapter popularAdapter = new PopularMovieRecyclerviewAdapter(getContext(), lstObMoviePopular);
        LinearLayoutManager popularLayoutManager = new LinearLayoutManager(getActivity());
        popularLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        popularRecyvlerview.setLayoutManager(popularLayoutManager);
        popularRecyvlerview.setAdapter(popularAdapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        newFeedData();
        hotMovieInitData();
        popularInitData();


    }


    public void newFeedData(){
        lstObMovieNewFeed = new ArrayList<>();
        lstObMovieNewFeed.add(new ObMovieNewFeed(R.drawable.tt1));
        lstObMovieNewFeed.add(new ObMovieNewFeed(R.drawable.tt2));
        lstObMovieNewFeed.add(new ObMovieNewFeed(R.drawable.tt3));
        lstObMovieNewFeed.add(new ObMovieNewFeed(R.drawable.tt5));
    }

    public void hotMovieInitData(){
        lstObMovieHotMovie = new ArrayList<>();
        lstObMovieHotMovie.add(new ObMovieHotMovie(R.drawable.now1,"Cá mập siêu bạo chúa"));
        lstObMovieHotMovie.add(new ObMovieHotMovie(R.drawable.now2,"Nhiệm vụ bất khả thi: Sụp đổ"));
        lstObMovieHotMovie.add(new ObMovieHotMovie(R.drawable.now3,"Christopher Robin"));
        lstObMovieHotMovie.add(new ObMovieHotMovie(R.drawable.now4, "Trí lực siêu phàm"));
        lstObMovieHotMovie.add(new ObMovieHotMovie(R.drawable.now5, "Bạn trai cũ tôi là điệp viên"));
        lstObMovieHotMovie.add(new ObMovieHotMovie(R.drawable.now6, "Mirai: Em gái đến từ tương lai"));
        lstObMovieHotMovie.add(new ObMovieHotMovie(R.drawable.now7, "Gia đình là tất cả"));
        lstObMovieHotMovie.add(new ObMovieHotMovie(R.drawable.imagemore, ""));

    }

    public void popularInitData(){
        lstObMoviePopular = new ArrayList<>();
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp1, "Tòa tháp trọc trời", R.drawable.pp2,"ET Cậu bé ngoài hành tinh", R.drawable.pp3,"Trùm bài", R.drawable.pp4,"Trừng phạt tội ác"));
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp5,"Trả thù", R.drawable.pp6, "Tiên tri ngày tận thế", R.drawable.pp7,"Sát thủ thợ máy: Sự tái xuất", R.drawable.pp8,"Gia đình cá mập"));
    }




}
