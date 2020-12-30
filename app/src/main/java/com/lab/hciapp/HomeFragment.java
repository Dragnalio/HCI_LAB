package com.lab.hciapp;

import android.content.Intent;
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
    ImageView ivBackwardArrow, ivForwardArrow;

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
        carouselImages.add(R.drawable.image1);
        carouselImages.add(R.drawable.image2);
        carouselImages.add(R.drawable.image3);
        carouselImages.add(R.drawable.image4);

        // view management
        tvWelcome = view.findViewById(R.id.home_tv_welcome);
        vfCarousel = view.findViewById(R.id.home_vf_carousel);

        ivBackwardArrow = view.findViewById(R.id.home_iv_backarrow);
        ivBackwardArrow.setOnClickListener(v -> {
            vfCarousel.stopFlipping();

            vfCarousel.setInAnimation(view.getContext(), R.anim.slide_in_left);
            vfCarousel.setOutAnimation(view.getContext(), R.anim.slide_out_right);

            vfCarousel.showPrevious();

            vfCarousel.stopFlipping();

            vfCarousel.startFlipping();

            vfCarousel.setInAnimation(view.getContext(), R.anim.slide_in_right);
            vfCarousel.setOutAnimation(view.getContext(), R.anim.slide_out_left);
        });

        ivForwardArrow = view.findViewById(R.id.home_iv_forwardarrow);
        ivForwardArrow.setOnClickListener(v -> {
            vfCarousel.stopFlipping();

            vfCarousel.showNext();

            vfCarousel.stopFlipping();

            vfCarousel.startFlipping();
        });

        for (Integer image: carouselImages) {
            ImageView imageView = new ImageView(view.getContext());
            imageView.setBackgroundResource(image);

            //masukin ke view flipper
            vfCarousel.addView(imageView);

            //auto rotate slider
            vfCarousel.setFlipInterval(5000);
            vfCarousel.setAutoStart(true);

            vfCarousel.setInAnimation(view.getContext(), R.anim.slide_in_right);
            vfCarousel.setOutAnimation(view.getContext(), R.anim.slide_out_left);
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