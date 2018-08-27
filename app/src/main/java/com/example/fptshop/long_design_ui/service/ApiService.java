package com.example.fptshop.long_design_ui.service;

import android.os.AsyncTask;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService extends AsyncTask<String, String, String> {

    private String url;
    private HandlerResponse handlerResponse;

    public static void load(String url, HandlerResponse handlerResponse) {
        ApiService apiService = new ApiService();
        apiService.url = url;
        apiService.handlerResponse = handlerResponse;
        apiService.execute();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(this.url);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();

            String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            this.handlerResponse.onFailure(e.getMessage());
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
    protected void onPostExecute(String finalJson) {
        try {
            JSONObject jBody = new JSONObject(finalJson);

            if(jBody.has("errorCode") && jBody.getInt("errorCode") == 1) {
                this.handlerResponse.onFailure(jBody.getString("message"));
            }

            if(jBody.has("errorCode") && jBody.getInt("errorCode") == 0) {
                this.handlerResponse.onSuccess(jBody.getString("data"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.handlerResponse.onFailure(e.getMessage());

        }

    }
}
