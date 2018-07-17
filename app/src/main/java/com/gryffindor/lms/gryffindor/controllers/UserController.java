package com.gryffindor.lms.gryffindor.controllers;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.gryffindor.lms.gryffindor.constants.SettingsConstant;
import com.gryffindor.lms.gryffindor.networks.HttpPoster;

public class UserController {
    public boolean doLogin(String username, String password) {
        boolean success = false;
        HttpPoster httpPoster = new HttpPoster();
        JsonObject requestObject = new JsonObject();
        requestObject.add("username", username);
        requestObject.add("password", password);
        try {
            String response = httpPoster.execute(SettingsConstant.baseURL + SettingsConstant.loginEndPoint, requestObject.toString()).get();
            success = Json.parse(response).asObject().getBoolean("success", false);
        } catch (Exception e) {

        }
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

        }
        return success;

    }

}
