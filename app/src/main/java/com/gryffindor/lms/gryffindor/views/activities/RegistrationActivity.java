package com.gryffindor.lms.gryffindor.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.gryffindor.lms.gryffindor.R;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner spGender;
    private Spinner spType;
    private TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        spGender = findViewById(R.id.spgender);
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvLogin:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
        }
    }
}
