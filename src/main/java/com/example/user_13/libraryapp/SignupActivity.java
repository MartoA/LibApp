package com.example.user_13.libraryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Intent registeredIntent = getIntent();
        Intent intent = getIntent();

        username = (EditText) findViewById(R.id.usernameET);
        password = (EditText) findViewById(R.id.passwordEV);
        login = (Button) findViewById(R.id.loginButton);
        register = (Button) findViewById(R.id.registerButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, RegistrationActivity.class);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SignupActivity.this);
                prefs.edit().putBoolean("IsLoggedIn", false).commit();
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UsersContainer.getInstance().contains(username.getText().toString())){
                    if(UsersContainer.getInstance().getUser(username.getText().toString()).getPassword().equals(password.getText().toString())){
                        Toast.makeText(SignupActivity.this, "You have logged in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SignupActivity.this);
                        prefs.edit().putBoolean("IsLoggedIn", true).commit();
                        startActivity(intent);
                    }
                    else{
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SignupActivity.this);
                        prefs.edit().putBoolean("IsLoggedIn", false).commit();
                    }
                }
                else{
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(SignupActivity.this);
                    prefs.edit().putBoolean("IsLoggedIn", false).commit();
                }

            }
        });


    }
}
