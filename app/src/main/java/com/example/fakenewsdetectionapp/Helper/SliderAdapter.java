package com.example.fakenewsdetectionapp.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.fakenewsdetectionapp.R;


public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    int images[]={
            R.drawable.newsonboardingsecond, R.drawable.newsonboardingfourr,R.drawable.newsonboardingthree,R.drawable.newsonboardingnew,
    };
    int headings[]={
            R.string.fist_slide_name,R.string.second_slide_name,R.string.third_slide_name,R.string.fourth_slide_name
    };
    int descriptions[]={
            R.string.first_slide_disc,R.string.second_slide_disc,R.string.third_slide_disc,R.string.fourth_slide_disc
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(ConstraintLayout)object;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);
        ImageView imageview = view.findViewById(R.id.slide_image);
        TextView heading = view.findViewById(R.id.slide_heading);
        TextView desc = view.findViewById(R.id.slide_desc);

        imageview.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
