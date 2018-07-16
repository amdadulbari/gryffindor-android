package com.gryffindor.lms.gryffindor.controllers;

import android.os.AsyncTask;
import android.util.Log;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.gryffindor.lms.gryffindor.constants.SettingsConstant;
import com.gryffindor.lms.gryffindor.networks.HttpPoster;

import java.util.concurrent.ExecutionException;

public class LoginController {
    public boolean doLogin(String username, String password) {
        boolean success = false;
        final JsonObject responseObject;
        HttpPoster httpPoster = new HttpPoster();
        JsonObject requestObject = new JsonObject();
        requestObject.add("username", username);
        requestObject.add("password", password);
        try {
            String response = httpPoster.execute(SettingsConstant.baseURL + SettingsConstant.loginEndPoint, requestObject.toString()).get();
            Log.d("JSON", response);
            success = Json.parse(response).asObject().getBoolean("success", false);
        }catch (Exception e){

        }
        return success;
    }

}
