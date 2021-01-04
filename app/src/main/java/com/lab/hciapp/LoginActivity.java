package com.lab.hciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    ImageView ivLogo;
    EditText etUsername, etPassword;
    Button btnSubmit, btnRegister;
    TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // imageviews
        ivLogo = findViewById(R.id.login_iv_logo);

        // edittexts
        etUsername = findViewById(R.id.login_et_username);
        etPassword = findViewById(R.id.login_et_password);

        // textviews
        tvError = findViewById(R.id.login_tv_error);

        // buttons
        btnSubmit = findViewById(R.id.login_btn_login);
        btnSubmit.setOnClickListener(v -> btnLoginPressed());

        btnRegister = findViewById(R.id.login_btn_register);
        btnRegister.setOnClickListener(v -> btnRegisterPressed());
    }

    // login action
    public void btnLoginPressed() {
        String error = "";
        tvError.setVisibility(View.GONE);

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if (username.length() <= 0 || password.length() <= 0) {
            error = getString(R.string.emptyfields);
            tvError.setText(error);
            tvError.setVisibility(View.VISIBLE);
            return;
        }

        User.userIndex = -1;
        for (int i=0; i<User.users.size(); i++) {
            if (User.users.get(i).getUserName().equals(username) && User.users.get(i).getPassword().equals(password)) {
                User.userIndex = i;
                break;
            }
        }

        if (User.userIndex < 0) {
            // invalid login credentials
            error = "Username or password is incorrect";
            tvError.setText(error);
            tvError.setVisibility(View.VISIBLE);
            return;
        }

        Intent intent = new Intent(this, FragmentControllerActivity.class);
        intent.putExtra("userIndex", User.userIndex);
        startActivity(intent);
    }

    // register action
    public void btnRegisterPressed() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}