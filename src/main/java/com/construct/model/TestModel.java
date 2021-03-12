package com.construct.model;

import java.util.List;

public class TestModel {
    private List<User> user;
    private String login;
    private String pwd;

    @Override
    public String toString() {
        return "TestModel{" +
                "user=" + user +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public TestModel() {
    }

    public TestModel(List<User> user, String login, String pwd) {
        this.user = user;
        this.login = login;
        this.pwd = pwd;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


}
