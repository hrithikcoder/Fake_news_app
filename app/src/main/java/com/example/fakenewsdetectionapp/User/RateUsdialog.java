package com.example.fakenewsdetectionapp.User;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

import com.example.fakenewsdetectionapp.R;


public class RateUsdialog extends Dialog {
    private float userrate=0;
    AppCompatButton ratingbtn;
    AppCompatButton laterbtn;
    RatingBar rateus;
    ImageView faceimage;

    public RateUsdialog(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us_dialog);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ratingbtn=findViewById(R.id.rate_now_btn);
        laterbtn=findViewById(R.id.later_btn);
        rateus=findViewById(R.id.ratingBar);
        faceimage=findViewById(R.id.faceimg);
        ratingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Your Ratings are submitted", Toast.LENGTH_SHORT).show();


            }
        });
        laterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

            }
        });

        rateus.setOnRatingBarChangeListener((ratingBar, v, b) -> {
            if(v<=1){
                faceimage.setImageResource(R.drawable.onestar);
            }
            else if(v<=2){
                faceimage.setImageResource(R.drawable.twostar);
            }
            else if(v<=3){
                faceimage.setImageResource(R.drawable.threestar);
            }
            else if(v<=4){
                faceimage.setImageResource(R.drawable.fourstar);
            }
            else{
                faceimage.setImageResource(R.drawable.fivestar);

            }

            animateImage(faceimage);
            userrate=v;




        });



    }




    private void animateImage(ImageView faceimage){
        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1f,0,1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        faceimage.startAnimation(scaleAnimation);

    }

}