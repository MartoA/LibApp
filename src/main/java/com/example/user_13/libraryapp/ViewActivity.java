package com.example.user_13.libraryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    private ImageView bookPicture;
    private TextView bookDescription;
    private TextView author;
    private TextView price;
    private TextView pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        bookDescription = (TextView) findViewById(R.id.descriptiontv);
        bookPicture = (ImageView) findViewById(R.id.bookpicture);
        author = (TextView) findViewById(R.id.author);
        pages = (TextView) findViewById(R.id.pages);
        price = (TextView) findViewById(R.id.price);

        Intent intent = getIntent();
        Book book =(Book) intent.getSerializableExtra("b");
        setTitle(book.getTitle());
        bookDescription.setText(book.getDescription());
        bookPicture.setImageResource(book.getPicID());
        author.setText(book.getAuthor());
        pages.setText(Integer.toString(book.getPages()));
        price.setText(Double.toString(book.getPrice()));


    }
}
