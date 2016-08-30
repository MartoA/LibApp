package com.example.user_13.libraryapp;

import java.io.Serializable;

/**
 * Created by Kali on 30.8.2016 г..
 */
public class Book implements Serializable{

    private static int id = 1;
    private int bookID;
    private String title;
    private String author;
    private int picID;
    private int pages;
    private double price;
    private String description;

    Book(String title, String author, int picID, int pages, double price){
        if(title!=null&&!title.isEmpty()){
            this.title = title;
        }
        if(author!=null&&!author.isEmpty()){
            this.author = author;
        }
        if(pages>0){
            this.pages = pages;
        }
        this.picID = picID;
        if(price>0){
            this.price = price;
        }
        bookID = id;
        id++;
    }

    public int getPages() {
        return pages;
    }

    public int getPicID() {
        return picID;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getBookID() {
        return bookID;
    }

    public String getDescription() {
        if(description==null){
            return "No description have been added";
        }
        return description;
    }

    public void setDescription(String description){
        if(description!=null&&!description.isEmpty()){
            this.description = description;
        }
    }
}
