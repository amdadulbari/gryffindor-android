package com.gryffindor.lms.gryffindor.networks;

import android.os.AsyncTask;
import android.util.Log;

import com.eclipsesource.json.JsonObject;
import com.gryffindor.lms.gryffindor.constants.SettingsConstant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpPoster extends AsyncTask<String,Void,String>{
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public String post(String url, String json) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        Log.d("JSON",json);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        String responseString =  response.body().string();
        Log.d("RESPONSE",responseString);
        return responseString;
        //Log.d("HTTP RESPONSE = ",responseBody);
    }


    @Override
    protected String doInBackground(String... strings) {
        String response = null;
        try {
            response = post(strings[0],strings[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
