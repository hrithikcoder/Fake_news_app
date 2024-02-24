package com.example.fakenewsdetectionapp.Home;


import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.airbnb.lottie.BuildConfig;
import com.example.fakenewsdetectionapp.R;
import com.example.fakenewsdetectionapp.User.MainRateUs;
import com.example.fakenewsdetectionapp.User.profileactivity;
import com.example.fakenewsdetectionapp.User.welcomepage;

import com.google.android.material.navigation.NavigationView;

public class MainHome extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuicon;
    AppCompatButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        add=findViewById(R.id.add_btn);


        menuicon=findViewById(R.id.menuicon);
        add.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), welcomepage.class);
            startActivity(intent);

        });

        navigationDrawer();




        
        //HomeRecycler =findViewById(R.id.homerecycler);
        
       // HomeRecycler();
    }

    private void navigationDrawer() {
        navigationView.bringToFront();

        navigationView.setCheckedItem(R.id.navigation_home);

        menuicon.setOnClickListener(view -> {
            if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            else{
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.navigation_home:
                    Intent intent4 = new Intent(getApplicationContext(),MainHome.class);
                    startActivity(intent4);
                    break;
                case R.id.navigation_share:
                    try{
                        Intent i = new Intent(Intent.ACTION_SEND);
                        i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_SUBJECT,"hrithik Das");
                        String shareMessage="https://play.google.com/store/apps/details?="+ BuildConfig.APPLICATION_ID+"\n\n";
                        i.putExtra(i.EXTRA_TEXT,shareMessage);
                        startActivity(Intent.createChooser(i,"Share With "));


                    }
                    catch (Exception e){
                        Toast.makeText(MainHome.this, "Unable to share this app", Toast.LENGTH_SHORT).show();
                    }

                case R.id.navigation_profile:
                    Intent intent3 = new Intent(getApplicationContext(), profileactivity.class);
                    startActivity(intent3);
                    break;


                case R.id.navigation_RATEUS:
                    Intent intent6=new Intent(getApplicationContext(), MainRateUs.class);
                    startActivity(intent6);
                    break;






                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }
            return true;

        });
    }

    //private void HomeRecycler() {
     /*   HomeRecycler.setHasFixedSize(true);
        HomeRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<HomeHelperClass>HomeLocation = new ArrayList<>();
        HomeLocation.add(new HomeHelperClass(R.drawable.bakeryone));
        HomeLocation.add(new HomeHelperClass(R.drawable.detailsrestro));
        HomeLocation.add(new HomeHelperClass(R.drawable.jubleepark));

        HomeAdapter homeAdapter=new HomeAdapter(HomeLocation);
        HomeRecycler.setAdapter(homeAdapter);



    }*/




}