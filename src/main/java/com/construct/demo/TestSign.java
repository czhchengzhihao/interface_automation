package com.construct.demo;

public class TestSign {

    public static void main(String[] args) {
        long sjc13 = System.currentTimeMillis();//13位时间戳
        String appkey = "429b1184c0317490dfa37bfd8e3ca8b4";
        String test = appkey + "|" + sjc13;
    }
}
