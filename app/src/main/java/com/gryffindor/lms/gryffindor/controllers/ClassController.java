package com.gryffindor.lms.gryffindor.controllers;

import android.content.SharedPreferences;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.gryffindor.lms.gryffindor.constants.SettingsConstant;
import com.gryffindor.lms.gryffindor.networks.HttpPoster;

public class ClassController {
    public boolean createClass(String username,String name,String details,String invitationCode){
        JsonObject requestObj = new JsonObject();
        requestObj.add("classUsername",username);
        requestObj.add("name",name);
        requestObj.add("details",details);
        requestObj.add("invitation_code",invitationCode);
        SharedPreferences pref = SettingsConstant.appContext.getSharedPreferences(SettingsConstant.userSharedPref, 0); // 0 - for private mode
        requestObj.add("creatorName",pref.getString("username",""));

        boolean success = false;
        HttpPoster httpPoster = new HttpPoster();
        try{
            String response = httpPoster.execute(SettingsConstant.baseURL + SettingsConstant.createClassEndPoint, requestObj.toString()).get();
            success = Json.parse(response).asObject().getBoolean("success", false);
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }

    public boolean joinClass(String invitationCode){
        JsonObject requestObj = new JsonObject();
        requestObj.add("invitationCode",invitationCode);
        SharedPreferences pref = SettingsConstant.appContext.getSharedPreferences(SettingsConstant.userSharedPref, 0); // 0 - for private mode
        requestObj.add("studentUserName",pref.getString("username",""));

        boolean success = false;
        HttpPoster httpPoster = new HttpPoster();
        try{
            String response = httpPoster.execute(SettingsConstant.baseURL + SettingsConstant.joinClassEndPoint, requestObj.toString()).get();
            success = Json.parse(response).asObject().getBoolean("success", false);
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;

    }

}
