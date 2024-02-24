package com.example.fakenewsdetectionapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.fakenewsdetectionapp.Helper.SliderAdapter;
import com.example.fakenewsdetectionapp.Home.MainHome;


public class onBoardingScreen extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letGetStarted;
    Animation animation;

    int currentPos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_screen);
        viewPager= findViewById(R.id.slider);
        dotsLayout=findViewById(R.id.dots);
        letGetStarted=findViewById(R.id.get_started_btn);



        sliderAdapter=new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }
    public void skip(View view){
        startActivity(new Intent(getApplicationContext(), MainHome.class));
        finish();

    }
    public void next(View view){
        viewPager.setCurrentItem(currentPos+1);


    }
    public void LetGetStarted(View view){
        startActivity(new Intent(getApplicationContext(),MainHome.class));


    }
    private void addDots(int position){
        dots=new TextView[4];
        dotsLayout.removeAllViews();

        for(int i =0; i<dots.length; i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }


    }
    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDots(position);
            currentPos=position;

            if(position==0){
                letGetStarted.setVisibility(viewPager.INVISIBLE);

            }
            else if(position==1){
                letGetStarted.setVisibility(viewPager.INVISIBLE);


            }
            else if(position==2){
                letGetStarted.setVisibility(viewPager.INVISIBLE);

            }
            else{
                animation= AnimationUtils.loadAnimation(onBoardingScreen.this,R.anim.bottom_anim);
                letGetStarted.setAnimation(animation);

                letGetStarted.setVisibility(viewPager.VISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}