package com.lab.hciapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    ImageView ivLogo;
    EditText etFullname, etUsername, etPassword;
    Button btnRegister, btnLogin;

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

        etFullname.setText("admin");
        etUsername.setText("admin123");
        etPassword.setText("admin");

        // buttons
        btnRegister = findViewById(R.id.register_btn_register);
        btnRegister.setOnClickListener(v -> btnRegisterPressed());

        btnLogin = findViewById(R.id.register_btn_login);
        btnLogin.setOnClickListener(v -> btnLoginPressed());
    }

    // register action
    public void btnRegisterPressed() {
        boolean valid = true;

        String fullName = etFullname.getText().toString();
        if (fullName.length() <= 0) {
            valid = false;
            makeToast(getString(R.string.fullname) + " must be filled");
        }

        String username = etUsername.getText().toString();
        if (username.length() <= 0) {
            valid = false;
            makeToast(getString(R.string.username) + " must be filled");
        }

        String password = etPassword.getText().toString();
        if (password.length() <= 0) {
            valid = false;
            makeToast(getString(R.string.password) + " must be filled");
        }

        if (!valid) {
            // empty input detected
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
            makeToast("This username is taken");
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

    void makeToast(String text) {
        Toast.makeText(this,  text, Toast.LENGTH_SHORT).show();
    }
}