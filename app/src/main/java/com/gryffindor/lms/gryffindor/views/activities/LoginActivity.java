package com.gryffindor.lms.gryffindor.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gryffindor.lms.gryffindor.R;
import com.gryffindor.lms.gryffindor.controllers.LoginController;

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
                LoginController loginController = new LoginController();
                boolean success = loginController.doLogin(email, password);
                if (success) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tvRegistration:
                Intent intent = new Intent(this,RegistrationActivity.class);
                startActivity(intent);
                break;
        }
    }


}
