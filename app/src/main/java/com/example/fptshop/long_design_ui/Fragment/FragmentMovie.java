package com.example.fptshop.long_design_ui.Fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fptshop.long_design_ui.Adapter.HotMovieMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Adapter.NewFeedMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Adapter.PopularMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Object.ObMovieHotMovie;
import com.example.fptshop.long_design_ui.Object.ObMovieNewFeed;
import com.example.fptshop.long_design_ui.Object.ObMoviePopular;
import com.example.fptshop.long_design_ui.Object.ObTrailer;
import com.example.fptshop.long_design_ui.R;

import com.google.gson.Gson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class FragmentMovie extends Fragment {
    static View v;

    List<ObMovieNewFeed>  movieModelList = new ArrayList<>();
    private RecyclerView popularRecyvlerview;
    List<ObMovieHotMovie> lstObMovieHotMovie = new ArrayList<>();
    private List<ObMoviePopular> lstObMoviePopular;
    CollapsingToolbarLayout collapsingToolbarLayout;
    private ProgressDialog dialog;
    Toolbar toolbar;
    final String BASE_URL = "http://45.76.147.88:11000/api/home/trailer";



    public FragmentMovie(){}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.movie_fragment,container,false);
        toolbar =  v.findViewById(R.id.toolbar);
        collapsingToolbarLayout = v.findViewById(R.id.collapsing_toolbar);




        //Trailer Recyclerview
        final RecyclerView newFeedRecyclerview = v.findViewById(R.id.recyclerviewNewFeed);
        NewFeedMovieRecyclerviewAdapter newFeedMovieRecyclerviewAdapter = new NewFeedMovieRecyclerviewAdapter(getContext(),movieModelList);
        LinearLayoutManager trailerLayoutManager = new LinearLayoutManager(getActivity());
        trailerLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        newFeedRecyclerview.setNestedScrollingEnabled(false);
        newFeedRecyclerview.setLayoutManager(trailerLayoutManager);
        newFeedRecyclerview.setAdapter(newFeedMovieRecyclerviewAdapter);

        //Recyclerview 2----------------------------------------------------------------------------
        final RecyclerView hotMovieRecyclerview = v.findViewById(R.id.recyclerviewNow);
        hotMovieRecyclerview.setNestedScrollingEnabled(false);
        HotMovieMovieRecyclerviewAdapter hotMovieMovieRecyclerviewAdapter = new HotMovieMovieRecyclerviewAdapter(getContext(),lstObMovieHotMovie);
        StaggeredGridLayoutManager hotMovieLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        hotMovieRecyclerview.setLayoutManager(hotMovieLayoutManager);
        hotMovieRecyclerview.setAdapter(hotMovieMovieRecyclerviewAdapter);


        //Recyclerview 3----------------------------------------------------------------------------
        popularRecyvlerview = (RecyclerView)v.findViewById(R.id.recyclerviewPopular);
        //Scroll View
        popularRecyvlerview.setNestedScrollingEnabled(false);

        PopularMovieRecyclerviewAdapter popularAdapter = new PopularMovieRecyclerviewAdapter(getContext(), lstObMoviePopular);
        StaggeredGridLayoutManager popularLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        popularRecyvlerview.setLayoutManager(popularLayoutManager);
        popularRecyvlerview.setAdapter(popularAdapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dialog = new ProgressDialog(getContext());
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.setMessage("Loading. Please wait..."); // showing a dialog for loading the data

        new TrailerJSONTask().execute("http://45.76.147.88:11000/api/home/trailer");

        new HotMovieJSONTask().execute("http://45.76.147.88:11000/api/home/now");

        popularInitData();


    }





    public class TrailerJSONTask extends AsyncTask<String, String, List<ObMovieNewFeed>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected List<ObMovieNewFeed> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line ="";
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }
                String finalJson = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray data = parentObject.getJSONArray("data");
                int errorCode = parentObject.getInt("errorCode");
                String message = parentObject.getString("message");


                Gson gson = new Gson();
                for(int i=0; i<data.length(); i++) {
                    JSONObject finalObject = data.getJSONObject(i);
                    /**
                     * below single line of code from Gson saves you from writing the json parsing yourself
                     * which is commented below
                     */
                    ObMovieNewFeed movieModel = gson.fromJson(finalObject.toString(), ObMovieNewFeed.class);
                    // adding the final object in the list
                    movieModelList.add(movieModel);
                }
                return movieModelList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null) {
                    connection.disconnect();
                }
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<ObMovieNewFeed> obMovieNewFeeds) {
            super.onPostExecute(obMovieNewFeeds);

            dialog.dismiss();
            if(obMovieNewFeeds != null) {

            } else {
                Toast.makeText(getContext(), "Not able to fetch data from server, please check url.", Toast.LENGTH_SHORT).show();
            }
        }
    }





    public class HotMovieJSONTask extends AsyncTask<String, String, List<ObMovieHotMovie>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected List<ObMovieHotMovie> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line ="";
                while ((line = reader.readLine()) != null){
                    buffer.append(line);
                }
                String finalJson = buffer.toString();


                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray data = parentObject.getJSONArray("data");



                Gson gson = new Gson();
                for(int i=0; i<data.length(); i++) {
                    JSONObject finalObject = data.getJSONObject(i);
                    /**
                     * below single line of code from Gson saves you from writing the json parsing yourself
                     * which is commented below
                     */
                    ObMovieHotMovie movieModel = gson.fromJson(finalObject.toString(), ObMovieHotMovie.class);
                    // adding the final object in the list
                    lstObMovieHotMovie.add(movieModel);
                }
                return lstObMovieHotMovie;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if(connection != null) {
                    connection.disconnect();
                }
                try {
                    if(reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<ObMovieHotMovie> obMovieHotMovie) {
            super.onPostExecute(obMovieHotMovie);

            dialog.dismiss();
            if(obMovieHotMovie != null) {

            } else {
                Toast.makeText(getContext(), "Not able to fetch data from server, please check url.", Toast.LENGTH_SHORT).show();
            }
        }
    }









    public void popularInitData(){
        lstObMoviePopular = new ArrayList<>();


        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp1, "Tòa tháp trọc trời"));
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp2, "ET Cậu bé ngoài hành tinh"));
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp3, "Trùm bài"));
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp4, "Trừng phạt tội ác"));
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp5, "Trả thù"));
        lstObMoviePopular.add(new ObMoviePopular(R.drawable.pp6, "Tiên tri ngày tận thế"));





    }




}
