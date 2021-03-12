package com.construct.demo;


import com.construct.model.TestModel;
import com.construct.model.User;

import java.util.ArrayList;
import java.util.List;

public class TestModelDemo {


    public static void main(String[] args) {
        User user = new User();
        user.setUser_login("aaa");
        user.setUser_pass("12345");
        System.out.println(user);

        List<User> users=new ArrayList<User>();
        users.add(user);
        TestModel testModel = new TestModel();
        testModel.setUser(users);
        testModel.setLogin("dadas");
        testModel.setPwd("aaaa");
        System.out.println(testModel);



    }

}
