package com.fitnessapp.views;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fitnessapp.R;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class AppIntroActivity extends AppIntro {


    // Please DO NOT override onCreate. Use init.
    @Override
    public void init(Bundle savedInstanceState) {
        // Instead of fragments, you can also use our default slide
        // Just set a title, description, background and image. AppIntro will do the rest.
        addSlide(AppIntroFragment.newInstance("Eye Catching Visuals", "Your Daily Statistics", R.drawable.appintro1, getResources().getColor(R.color.appintro1)));
        //addSlide(AppIntroFragment.newInstance("Who is the best?", "Compare with Friends", R.drawable.appintro5, getResources().getColor(R.color.appintro2)));
        addSlide(AppIntroFragment.newInstance("Invite Friends", "Share A Run with them", R.drawable.appintro3, getResources().getColor(R.color.appintro3)));
        addSlide(AppIntroFragment.newInstance("", "Get Started", R.drawable.appintro4, getResources().getColor(R.color.appintro4)));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#F44336"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

    }

    @Override
    public void onSkipPressed() {
        // Do something when users tap on Skip button.
        Intent i = new Intent(AppIntroActivity.this, EnterUserInfoActivity.class);
        startActivity(i);
    }

    @Override
    public void onDonePressed() {
        // Do something when users tap on Done button.
        Intent i = new Intent(AppIntroActivity.this, EnterUserInfoActivity.class);
        startActivity(i);

    }

    @Override
    public void onSlideChanged() {
    }

    @Override
    public void onNextPressed() {
    }

}
