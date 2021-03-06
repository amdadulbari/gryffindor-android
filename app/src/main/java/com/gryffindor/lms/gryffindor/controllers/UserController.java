package com.gryffindor.lms.gryffindor.controllers;

import android.content.SharedPreferences;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.gryffindor.lms.gryffindor.constants.SettingsConstant;
import com.gryffindor.lms.gryffindor.networks.HttpPoster;

import java.util.concurrent.ExecutionException;

public class UserController {
    public boolean doLogin(String username, String password) {
        boolean success = false;
        HttpPoster httpPoster = new HttpPoster();
        JsonObject requestObject = new JsonObject();
        String name,email,dob,gender,type,status;
        requestObject.add("username", username);
        requestObject.add("password", password);
        try {
            String response = httpPoster.execute(SettingsConstant.baseURL + SettingsConstant.loginEndPoint, requestObject.toString()).get();

            JsonObject responseObject = Json.parse(response).asObject();
            JsonObject userObject = responseObject.get("user").asObject();
            JsonArray classList = responseObject.get("class").asArray();

            success = responseObject.getBoolean("success", false);
            name = userObject.getString("username","");
            email = userObject.getString("email","");
            dob = userObject.getString("dob","");
            gender = userObject.getString("gender","");
            status = userObject.getString("status","");
            type = userObject.getString("type","");

            SharedPreferences pref = SettingsConstant.appContext.getSharedPreferences(SettingsConstant.userSharedPref, 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("username",username);
            editor.putString("email",email);
            editor.putString("dob",dob);
            editor.putString("name",name);
            editor.putString("gender",gender);
            editor.putString("status",status);
            editor.putString("type",type);
            editor.putString("classes",classList.toString());
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("SUCCESS = "+success);
        return success;
    }

    public boolean doRegistration(String username, String email, String password, String dob, String type, String gender) {
        boolean success = false;
        HttpPoster httpPoster = new HttpPoster();
        JsonObject requestObject = new JsonObject();
        requestObject.add("username", username);
        requestObject.add("email", email);
        requestObject.add("password", password);
        requestObject.add("dateOfBirth", dob);
        requestObject.add("type", type);
        requestObject.add("gender", gender);
        try {
            String response = httpPoster.execute(SettingsConstant.baseURL + SettingsConstant.signupEndPoint, requestObject.toString()).get();
            success = Json.parse(response).asObject().getBoolean("success", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;

    }

    public boolean verifyUser(String code){
        String response;
        boolean success=false;
        JsonObject requestObject = new JsonObject();
        SharedPreferences pref = SettingsConstant.appContext.getSharedPreferences(SettingsConstant.userSharedPref, 0); // 0 - for private mode
        requestObject.add("username",pref.getString("username",""));
        requestObject.add("approvalCode",code);
        HttpPoster httpPoster = new HttpPoster();
        try {
            response = httpPoster.execute(SettingsConstant.baseURL+SettingsConstant.verificationEndPoint,requestObject.toString()).get();
            success = Json.parse(response).asObject().getBoolean("success",false);
            if(success==true){
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("status","active");
                editor.commit();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return success;
    }
}
