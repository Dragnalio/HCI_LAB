package com.lab.hciapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ImageView ivLogo;
    EditText etUsername, etPassword;
    Button btnSubmit, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // manage vectors
        User.addUser(new User("Admin", "admin", "admin"));
        User.addUser(new User("Andi", "admin1", "admin"));
        User.addUser(new User("Anto", "admin2", "admin"));

        // imageviews
        ivLogo = findViewById(R.id.login_iv_logo);

        // edittexts
        etUsername = findViewById(R.id.login_et_username);
        etPassword = findViewById(R.id.login_et_password);

        etUsername.setText("admin");
        etPassword.setText("admin");

        // buttons
        btnSubmit = findViewById(R.id.login_btn_login);
        btnSubmit.setOnClickListener(v -> btnLoginPressed());

        btnRegister = findViewById(R.id.login_btn_register);
        btnRegister.setOnClickListener(v -> btnRegisterPressed());
    }

    // login action
    public void btnLoginPressed() {
        boolean valid = true;

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
            if (User.users.get(i).getUserName().equals(username) && User.users.get(i).getPassword().equals(password)) {
                User.userIndex = i;
                break;
            }
        }

        if (User.userIndex < 0) {
            // invalid login credentials
            makeToast("Invalid login credentials");
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

    void makeToast(String text) {
        Toast.makeText(this,  text, Toast.LENGTH_SHORT).show();
    }
}