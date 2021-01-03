package com.lab.hciapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    ImageView ivImage;
    TextView tvName;

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    TabViewAdapter tabViewAdapter;
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // views
        ivImage = findViewById(R.id.detail_iv_image);
        tvName = findViewById(R.id.detail_tv_name);

        ivImage.setImageResource(Recipe.recipe.getImage());
        tvName.setText(Recipe.recipe.getName());

        tabLayout = findViewById(R.id.detail_tl_tab);
        viewPager2 = findViewById(R.id.detail_vp_page);

        // add fragments to AL
        fragments.add(new DescriptionFragment());
        fragments.add(new InstructionFragment());

        if(tabs.isEmpty()){
            tabs.add("Description");
            tabs.add("Instructions");
        }

        tabViewAdapter = new TabViewAdapter(this, fragments);
        viewPager2.setAdapter(tabViewAdapter);

        // setup TabLayoutMediator
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            // set tab berdasarkan posisi
            tab.setText(tabs.get(position));
        }).attach();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}