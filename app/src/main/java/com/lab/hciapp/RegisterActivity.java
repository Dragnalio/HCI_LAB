package com.lab.hciapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    ImageView ivLogo;
    EditText etFullname, etUsername, etPassword;
    Button btnRegister, btnLogin;
    TextView tvError;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // imageviews
        ivLogo = findViewById(R.id.register_iv_logo);

        // edittexts
        etFullname = findViewById(R.id.register_et_fullname);
        etUsername = findViewById(R.id.register_et_username);
        etPassword = findViewById(R.id.register_et_password);

        // textviews
        tvError = findViewById(R.id.register_tv_error);

        // buttons
        btnRegister = findViewById(R.id.register_btn_register);
        btnRegister.setOnClickListener(v -> btnRegisterPressed());

        btnLogin = findViewById(R.id.register_btn_login);
        btnLogin.setOnClickListener(v -> btnLoginPressed());
    }

    // register action
    public void btnRegisterPressed() {
        String error = "";
        tvError.setVisibility(View.GONE);

        String fullName = etFullname.getText().toString();
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if (fullName.length() <= 0 || username.length() <= 0 || password.length() <= 0) {
            error = getString(R.string.emptyfields);
            tvError.setText(error);
            tvError.setVisibility(View.VISIBLE);
            return;
        } else if (username.length() < 6 || password.length() < 6) {
            error = "Username and password length must be at least 6 character";
            tvError.setText(error);
            tvError.setVisibility(View.VISIBLE);
            return;
        }

        User.userIndex = -1;
        for (int i=0; i<User.users.size(); i++) {
            if (User.users.get(i).getUserName().equals(username)) {
                User.userIndex = i;
                break;
            }
        }

        if (User.userIndex >= 0) {
            // duplicate username
            error = "This username is taken";
            tvError.setText(error);
            tvError.setVisibility(View.VISIBLE);
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Register");
        builder.setMessage("Are you sure you want to register?");
        builder.setCancelable(true);

        // Add the buttons
        builder.setPositiveButton(R.string.confirm, (dialog, id) -> {
            Intent intent = new Intent(context, FragmentControllerActivity.class);
            User.userIndex = User.users.size();
            User.addUser(new User(fullName, username, password));
            startActivity(intent);
        });
        builder.setNegativeButton(R.string.cancel, (dialog, id) -> {

        });
        // Create the AlertDialog
        AlertDialog dialog = builder.create();

        dialog.show();
    }

    // login action
    public void btnLoginPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}