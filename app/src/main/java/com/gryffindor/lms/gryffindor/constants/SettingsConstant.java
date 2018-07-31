package com.gryffindor.lms.gryffindor.constants;

import android.content.Context;

public class SettingsConstant {
    public static String baseURL = "http://159.65.77.215:8080/gryffindor";
    //public static String baseURL = "http://192.168.0.103:8080/";
    public static String loginEndPoint = "/api/user/login";
    public static String signupEndPoint = "/api/user/create";
    public static String verificationEndPoint = "/api/user/validate";
    public static String createClassEndPoint = "/api/classroom/create";
    public static String joinClassEndPoint = "/api/classroom/join";


    public static String userSharedPref = "userSharedPref";
    public static Context appContext;

}
