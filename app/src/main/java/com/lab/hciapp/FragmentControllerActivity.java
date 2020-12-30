package com.lab.hciapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentControllerActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
//    private NavHostFragment navigationHostFragment;
    private NavController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentcontroller);

        bottomNavigationView = findViewById(R.id.fragmentcontroller_bnv_navbar);
//        navigationHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentcontroller_fragment_manager);
//        navigationController = navigationHostFragment.getNavController();
        navigationController = Navigation.findNavController(this, R.id.fragmentcontroller_fragment_manager);
        NavigationUI.setupWithNavController(bottomNavigationView, navigationController);
    }
}