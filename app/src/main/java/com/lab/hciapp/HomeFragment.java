package com.lab.hciapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Vector;

public class HomeFragment extends Fragment {

    TextView tvWelcome;
    ViewFlipper vfCarousel;

    Vector<Integer> carouselImages;
    User user;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // vector management
        carouselImages = new Vector<>();
        for (Recipe recipe : Recipe.recipes) {
            carouselImages.add(recipe.getImage());
        }

        // view management
        tvWelcome = view.findViewById(R.id.home_tv_welcome);
        vfCarousel = view.findViewById(R.id.home_vf_carousel);

        for (Integer image: carouselImages) {
            ImageView imageView = new ImageView(view.getContext());
            imageView.setBackgroundResource(image);

            //masukin ke view flipper
            vfCarousel.addView(imageView);

            //auto rotate slider
            vfCarousel.setFlipInterval(5000);
            vfCarousel.setInAnimation(view.getContext(), R.anim.slide_in_right);
            vfCarousel.setOutAnimation(view.getContext(), R.anim.slide_out_left);
            vfCarousel.setAutoStart(true);
    }

        // get intent data
        if (User.userIndex >= 0) {
            user = User.users.get(User.userIndex);
            String welcomeText = getString(R.string.welcome) + user.getFullName();
            tvWelcome.setText(welcomeText);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


}