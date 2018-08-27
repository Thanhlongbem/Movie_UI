package com.example.fptshop.long_design_ui.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fptshop.long_design_ui.service.ApiService;
import com.example.fptshop.long_design_ui.adapter.HotMovieMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.adapter.NewFeedMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.adapter.PopularMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.object.ObMovieHotMovie;
import com.example.fptshop.long_design_ui.object.ObMovieNewFeed;
import com.example.fptshop.long_design_ui.object.ObMoviePopular;
import com.example.fptshop.long_design_ui.R;

import com.example.fptshop.long_design_ui.service.HandlerResponse;
import com.example.fptshop.long_design_ui.utils.ApiUri;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class FragmentMovie extends Fragment {

    private static final String TAG = "FragmentMovie";

    static View v;

    List<ObMovieNewFeed>  movieModelList = new ArrayList<>();
    List<ObMovieHotMovie> lstObMovieHotMovie = new ArrayList<>();
    List<ObMoviePopular> lstObMoviePopular = new ArrayList<>();
    CollapsingToolbarLayout collapsingToolbarLayout;

    NewFeedMovieRecyclerviewAdapter newFeedMovieRecyclerviewAdapter;
    HotMovieMovieRecyclerviewAdapter hotMovieMovieRecyclerviewAdapter;
    PopularMovieRecyclerviewAdapter popularMovieRecyclerviewAdapter;

    private ProgressDialog dialog;
    Toolbar toolbar;

    public FragmentMovie(){}



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        v = inflater.inflate(R.layout.movie_fragment,container,false);
        toolbar =  v.findViewById(R.id.toolbar);
        collapsingToolbarLayout = v.findViewById(R.id.collapsing_toolbar);

        //Trailer Recyclerview
        final RecyclerView newFeedRecyclerview = v.findViewById(R.id.recyclerviewNewFeed);
        newFeedMovieRecyclerviewAdapter = new NewFeedMovieRecyclerviewAdapter(getContext(),movieModelList);
        LinearLayoutManager trailerLayoutManager = new LinearLayoutManager(getActivity());
        trailerLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        newFeedRecyclerview.setNestedScrollingEnabled(false);
        newFeedRecyclerview.setLayoutManager(trailerLayoutManager);
        newFeedRecyclerview.setAdapter(newFeedMovieRecyclerviewAdapter);

        //Now Movie Recyclerview ----------------------------------------------------------------------------
        final RecyclerView hotMovieRecyclerview = v.findViewById(R.id.recyclerviewNow);
        hotMovieRecyclerview.setNestedScrollingEnabled(false);
        hotMovieMovieRecyclerviewAdapter = new HotMovieMovieRecyclerviewAdapter(getContext(), lstObMovieHotMovie);
        LinearLayoutManager hotMovieLayoutManager = new LinearLayoutManager(getContext());
        hotMovieLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        hotMovieRecyclerview.setLayoutManager(hotMovieLayoutManager);
        hotMovieRecyclerview.setAdapter(hotMovieMovieRecyclerviewAdapter);

        //Popular Movie Recyclerview ----------------------------------------------------------------------------
        final RecyclerView popularRecyvlerview = v.findViewById(R.id.recyclerviewPopular);
        popularRecyvlerview.setNestedScrollingEnabled(false);
        popularMovieRecyclerviewAdapter = new PopularMovieRecyclerviewAdapter(getContext(), lstObMoviePopular);
        StaggeredGridLayoutManager popularMovieLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
        popularRecyvlerview.setLayoutManager(popularMovieLayoutManager);
        popularRecyvlerview.setAdapter(popularMovieRecyclerviewAdapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dialog = new ProgressDialog(getContext());
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Loading. Please wait..."); // showing a dialog for loading the data

        //ApiService.load(ApiUri.API_HOME_TRAILER, new HandlerHomeMovie<>(movieModelList, newFeedMovieRecyclerviewAdapter));
        ApiService.load(ApiUri.API_HOME_TRAILER, new HandlerResponse() {

            @Override
            public void onSuccess(String responseString) {
                List<ObMovieNewFeed> results = new Gson().fromJson(responseString, new TypeToken<List<ObMovieNewFeed>>(){}.getType());
                movieModelList.addAll(results);
                newFeedMovieRecyclerviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                Log.e(TAG, message);
            }
        });


        //ApiService.load(ApiUri.API_HOME_NOW, new HandlerHomeMovie<>(lstObMovieHotMovie, hotMovieMovieRecyclerviewAdapter));
        ApiService.load(ApiUri.API_HOME_NOW, new HandlerResponse() {

            @Override
            public void onSuccess(String responseString) {
                List<ObMovieHotMovie> results = new Gson().fromJson(responseString, new TypeToken<List<ObMovieHotMovie>>(){}.getType());
                lstObMovieHotMovie.addAll(results);
                hotMovieMovieRecyclerviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                Log.e(TAG, message);
            }
        });

        //ApiService.load(ApiUri.API_HOME_POPULAR, new HandlerHomeMovie<>(lstObMovieHotMovie, popularMovieRecyclerviewAdapter));
        ApiService.load(ApiUri.API_HOME_POPULAR, new HandlerResponse() {

            @Override
            public void onSuccess(String responseString) {
                List<ObMoviePopular> results = new Gson().fromJson(responseString, new TypeToken<List<ObMoviePopular>>(){}.getType());
                lstObMoviePopular.addAll(results);
                popularMovieRecyclerviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                Log.e(TAG, message);
            }
        });

    }


    //read more: Java Generic
    private class HandlerHomeMovie<T> implements HandlerResponse {

        private RecyclerView.Adapter adapter;
        private List<T> items;

        public HandlerHomeMovie(List<T> items, HotMovieMovieRecyclerviewAdapter adapter) {
            this.adapter = adapter;
            this.items = items;
        }

        @Override
        public void onSuccess(String responseString) {
            List<T> results = new Gson().fromJson(responseString, new TypeToken<List<T>>(){}.getType());
            items.addAll(results);
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onFailure(String response) {

        }
    }
}
