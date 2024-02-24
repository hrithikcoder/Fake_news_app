package com.example.fakenewsdetectionapp.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.fakenewsdetectionapp.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;



public class SignUp extends AppCompatActivity {
    TextView login;
    EditText email,password;
    Button register;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sign_up);
        login=findViewById(R.id.loginBtn);



        email=findViewById(R.id.Email);
        password=findViewById(R.id.Password);
        register=findViewById(R.id.Register);
        //conpassword=findViewById(R.id.ConPassword);
        auth=FirebaseAuth.getInstance();
       register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=email.getText().toString().trim();
                String pass=password.getText().toString().trim();
                if(user.isEmpty()){
                    email.setError("Email cannot be empty");
                }
                else if(pass.isEmpty()){
                    password.setError("Password cannot be empty");
                }
                else{
                    auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Signup SuccessFull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUp.this,login.class));
                        }
                        else{
                            Toast.makeText(SignUp.this, "Signup Failed"+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,login.class));
            }
        });
    }
}