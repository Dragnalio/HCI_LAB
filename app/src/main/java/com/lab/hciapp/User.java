package com.lab.hciapp;

import java.util.Vector;

public class User {

    public static Vector<User> users = new Vector<>();
    public static int userIndex = -1;

    private String fullName, userName, password;

    public User(String fullName, String userName, String password){
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser(){
        return this;
    }

    public static void addUser(User user) {
        users.add(user);
    }
}
