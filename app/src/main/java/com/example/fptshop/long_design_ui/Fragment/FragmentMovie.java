package com.example.fptshop.long_design_ui.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fptshop.long_design_ui.Adapter.NewFeedMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Adapter.NowMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Adapter.PopularMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.MainActivity;
import com.example.fptshop.long_design_ui.Object.ObMovieNewFeed;
import com.example.fptshop.long_design_ui.Object.ObMovieNow;
import com.example.fptshop.long_design_ui.Object.ObMoviePopular;
import com.example.fptshop.long_design_ui.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentMovie extends Fragment {
    View v,v1;
    private RecyclerView newFeedRecyclerview;
    private RecyclerView nowRecyvlerview;
    private RecyclerView popularRecyvlerview;
    private List<ObMovieNewFeed> lstObMovieNewFeed;
    private List<ObMovieNow> lstObMovieNow;
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
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context,newFeedLayoutManager.getOrientation());
        newFeedRecyclerview.addItemDecoration(dividerItemDecoration);
        newFeedRecyclerview.setAdapter(newFeedadapter);


        //Recyclerview 2----------------------------------------------------------------------------
        nowRecyvlerview = (RecyclerView)v.findViewById(R.id.recyclerviewNow);
        //Scroll View
        nowRecyvlerview.setNestedScrollingEnabled(false);

        NowMovieRecyclerviewAdapter nowAdapter = new NowMovieRecyclerviewAdapter(getContext(),lstObMovieNow);
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

        lstObMovieNewFeed = new ArrayList<>();
        lstObMovieNewFeed.add(new ObMovieNewFeed(R.drawable.tt1));
        lstObMovieNewFeed.add(new ObMovieNewFeed(R.drawable.tt2));
        lstObMovieNewFeed.add(new ObMovieNewFeed(R.drawable.tt3));
        lstObMovieNewFeed.add(new ObMovieNewFeed(R.drawable.tt5));


        lstObMovieNow = new ArrayList<>();
        lstObMovieNow.add(new ObMovieNow(R.drawable.now1, R.drawable.now2));
        lstObMovieNow.add(new ObMovieNow(R.drawable.now3, R.drawable.now4));
        lstObMovieNow.add(new ObMovieNow(R.drawable.now5, R.drawable.now6));

        lstObMoviePopular = new ArrayList<>();
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp1, R.drawable.pp2, R.drawable.pp3, R.drawable.pp4));
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp5, R.drawable.pp6, R.drawable.pp7, R.drawable.pp8));



    }
}
