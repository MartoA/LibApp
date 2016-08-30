package com.example.user_13.libraryapp;

/**
 * Created by user-13 on 8/29/16.
 */
public class User {

    private String username;
    private String name;
    private String password;
    private String email;
    private boolean isLogged;

    User(String username, String name, String password, String email){
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isLogged = false;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

}
