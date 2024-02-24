package com.example.fakenewsdetectionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.fakenewsdetectionapp.Home.MainHome;


public class SplashSCreen extends AppCompatActivity {
    TextView news;
    LottieAnimationView lottieAnimationView;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        news=findViewById(R.id.newsletter);
        lottieAnimationView=findViewById(R.id.newsscreen);
        news.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        lottieAnimationView.animate().translationX(2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(() -> {
            onBoardingScreen=getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
            boolean isFirstTime= onBoardingScreen.getBoolean("firstTime",true);
            if(isFirstTime) {
                SharedPreferences.Editor editor=onBoardingScreen.edit();
                editor.putBoolean("firstTime",false);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(), onBoardingScreen.class);
                startActivity(intent);
                finish();

            }
            else{
                Intent intent = new Intent(getApplicationContext(), MainHome.class);
                startActivity(intent);
                finish();

            }

        },5000);
    }
}