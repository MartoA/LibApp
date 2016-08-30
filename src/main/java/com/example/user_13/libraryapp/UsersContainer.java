package com.example.user_13.libraryapp;

import java.util.HashMap;

/**
 * Created by Kali on 29.8.2016 г..
 */
public class UsersContainer {

    private static UsersContainer ourInstance = new UsersContainer();
    private static HashMap<String, User> usersByUsername;
    private static HashMap<String, User> usersByMail;

    public static UsersContainer getInstance() {
        return ourInstance;
    }

    private UsersContainer() {
        usersByUsername = new HashMap<>();
        usersByMail = new HashMap<>();
    }

   public void addUser(User user){
        usersByUsername.put(user.getUsername(), user);
        usersByMail.put(user.getEmail(), user);
   }

    public boolean contains(String username) {
        return usersByUsername.containsKey(username);
    }

    public boolean containsMail(String mail){
        return usersByMail.containsKey(mail);
    }

    public User getUser(String username){
        return usersByUsername.get(username);
    }
}
