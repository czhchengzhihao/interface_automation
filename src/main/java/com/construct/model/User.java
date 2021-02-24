package com.construct.model;

public class User {

    private String user_login;
    private String user_pass;

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public User(String user_login, String user_pass) {
        this.user_login = user_login;
        this.user_pass = user_pass;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_login='" + user_login + '\'' +
                ", user_pass='" + user_pass + '\'' +
                '}';
    }
}
