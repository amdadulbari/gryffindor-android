package com.gryffindor.lms.gryffindor.views.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gryffindor.lms.gryffindor.R;
import com.gryffindor.lms.gryffindor.controllers.UserController;

public class AccountVerifyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etVerificationCode;
    private Button btnSubmit;

    private String verificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_verify);
        etVerificationCode = findViewById(R.id.etVerificationCode);
        btnSubmit = findViewById(R.id.btnVerify);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        verificationCode = etVerificationCode.getText().toString();
        switch (v.getId()) {
            case R.id.btnVerify:
                boolean success;
                UserController userController = new UserController();
                success = userController.verifyUser(verificationCode);
                if (success) {
                    Intent intent = new Intent(this, HomepageActivity.class);
                    startActivity(intent);
                }
        }
    }
}
