package com.gryffindor.lms.gryffindor.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gryffindor.lms.gryffindor.R;
import com.gryffindor.lms.gryffindor.controllers.UserController;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spGender;
    private Spinner spType;
    private TextView tvLogin;
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etDob;
    private TextView tvRegis;

    private String email;
    private String password;
    private String dob;
    private String gender;
    private String type;
    private String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etUsername = findViewById(R.id.etUserReg);
        etEmail = findViewById(R.id.etemailReg);
        etPassword = findViewById(R.id.etpasswordReg);
        etDob = findViewById(R.id.etdobReg);
        spGender = findViewById(R.id.spgender);
        spType = findViewById(R.id.sptype);

        tvLogin = findViewById(R.id.tvLogin);
        tvRegis = findViewById(R.id.tvRegis);

        tvLogin.setOnClickListener(this);
        tvRegis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        username = etUsername.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();
        dob = etDob.getText().toString();
        type = spType.getSelectedItem().toString();
        gender = spType.getSelectedItem().toString();
        switch (v.getId()) {
            case R.id.tvLogin:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btnReg:
                boolean success;
                UserController userController = new UserController();
                success = userController.doRegistration(username, email, password, dob, type, gender);
                if (success == true) {
                    Toast.makeText(getApplicationContext(), "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(this, AccountVerifyActivity.class);
                    startActivity(loginIntent);
                } else {
                    Toast.makeText(getApplicationContext(), "Failed to create account", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
