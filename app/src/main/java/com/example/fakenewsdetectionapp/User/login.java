package com.example.fakenewsdetectionapp.User;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fakenewsdetectionapp.Home.MainHome;
import com.example.fakenewsdetectionapp.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;


public class login extends AppCompatActivity {
    private TextView loginsignUp;
    private EditText loginemail,loginpassword;
    private  Button loginbtn;
    //private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        loginsignUp=findViewById(R.id.signup);
        //auth=FirebaseAuth.getInstance();


        loginemail=findViewById(R.id.email);
        loginpassword=findViewById(R.id.password);
        loginbtn=findViewById(R.id.login);
        loginsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });
        /*loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=loginemail.getText().toString();
                String pass=loginpassword.getText().toString();
                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!pass.isEmpty()){
                       // auth.signInWithEmailAndPassword(email,pass)
                           //     .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(login.this, "Login SuccessFul", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(login.this, MainHome.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }else{
                        loginpassword.setError("Password cannot be empty");
                    }

                } else if(email.isEmpty()){
                    loginemail.setError("Email cannot be empty");
                }else{
                    loginemail.setError("Please enter valid email");
                }
            }
        });
        loginsignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this,SignUp.class));
            }
        });*/
    }
}