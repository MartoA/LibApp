package com.example.user_13.libraryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BougthActivity extends AppCompatActivity {

    private TextView boughtbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bougth);

        boughtbook = (TextView) findViewById(R.id.boughtbook);

        Intent intent = getIntent();
        boughtbook.setText(intent.getStringExtra("b"));
    }
}
