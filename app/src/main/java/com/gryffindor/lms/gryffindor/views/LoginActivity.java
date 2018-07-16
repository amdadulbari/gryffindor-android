package com.gryffindor.lms.gryffindor.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gryffindor.lms.gryffindor.R;
import com.gryffindor.lms.gryffindor.controllers.LoginController;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;

    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.etemail);
        etPassword = findViewById(R.id.etpassword);
        btnLogin = findViewById(R.id.btnlogin);

        //email = etEmail.getText().toString();
        //password = etPassword.getText().toString();

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnlogin:
                LoginController loginController = new LoginController();
                boolean success = loginController.doLogin("amdadulbari", "abc");
                if (success) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
        }
    }


}
