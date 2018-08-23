package com.example.fptshop.long_design_ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
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
import android.widget.Toast;

import com.example.fptshop.long_design_ui.Adapter.AllHotMovieRecyclerviewAdapter;
import com.example.fptshop.long_design_ui.Object.ObAllHotMovie;
import com.example.fptshop.long_design_ui.Object.ObMovieHotMovie;
import com.example.fptshop.long_design_ui.R;
import com.google.gson.Gson;

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

public class AllHotMovie extends AppCompatActivity{

    Button btnBackFromAllHotMovie;
    RecyclerView recyclerviewAllHotMovie;
    ProgressDialog dialog;
    List<ObAllHotMovie> lstAllHotMovie = new ArrayList<>();
    AllHotMovieRecyclerviewAdapter allHotMovieRecyclerviewAdapter;

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

        new AllHotMovieJSONTask().execute("http://45.76.147.88:11000/api/home/now");

        initAllHotMovie();
    }


    public void initAllHotMovie(){
        recyclerviewAllHotMovie = findViewById(R.id.recyclerviewAllHotMovie);
        allHotMovieRecyclerviewAdapter = new AllHotMovieRecyclerviewAdapter(getApplicationContext(),lstAllHotMovie);
        StaggeredGridLayoutManager allHotMovieStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerviewAllHotMovie.setLayoutManager(allHotMovieStaggeredGridLayoutManager);
        recyclerviewAllHotMovie.setAdapter(allHotMovieRecyclerviewAdapter);
    }




    public class AllHotMovieJSONTask extends AsyncTask<String, String, List<ObAllHotMovie>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(getApplicationContext());
            dialog.setIndeterminate(true);
            dialog.setCancelable(false);
            dialog.setMessage("Loading. Please wait..."); // showing a dialog for loading the data
        }

        @Override
        protected List<ObAllHotMovie> doInBackground(String... params) {
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
                    ObAllHotMovie movieModel = gson.fromJson(finalObject.toString(), ObAllHotMovie.class);
                    // adding the final object in the list
                    lstAllHotMovie.add(movieModel);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        allHotMovieRecyclerviewAdapter.notifyDataSetChanged();
                    }
                });
                return lstAllHotMovie;

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
        protected void onPostExecute(List<ObAllHotMovie> obAllHotMovie) {
            super.onPostExecute(obAllHotMovie);

            dialog.dismiss();
            if(obAllHotMovie != null) {

            } else {
                Context context = getApplicationContext();
                Toast.makeText(context, "Not able to fetch data from server, please check url.", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
