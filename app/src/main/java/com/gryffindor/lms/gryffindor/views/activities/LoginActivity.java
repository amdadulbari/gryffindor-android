package com.gryffindor.lms.gryffindor.views.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gryffindor.lms.gryffindor.R;
import com.gryffindor.lms.gryffindor.constants.SettingsConstant;
import com.gryffindor.lms.gryffindor.controllers.UserController;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvRegistration;

    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etemail);
        etPassword = findViewById(R.id.etpassword);
        tvRegistration = findViewById(R.id.tvRegistration);
        btnLogin = findViewById(R.id.btnlogin);


        btnLogin.setOnClickListener(this);
        tvRegistration.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        switch (v.getId()) {
            case R.id.btnlogin:
                UserController userController = new UserController();
                boolean success = userController.doLogin(email, password);
                if (success) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences(SettingsConstant.userSharedPref, 0);
                    String status = pref.getString("status","");
                    Log.d("Status = ",status) ;
                    if(status.equals("active")){
                        Intent intent = new Intent(this,HomePageActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(this,AccountVerifyActivity.class);
                        startActivity(intent);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvRegistration:
                Intent intent = new Intent(this, RegistrationActivity.class);
                startActivity(intent);
                break;
        }
    }


}
