package com.construct.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class tester {
    @Test
    public void test1() {
        Assert.assertEquals("aa", "aa");
    }

    @Test
    public void test2() {
        Assert.assertEquals("aa", "bb");
    }

    @Test
    public void test3() {
        Assert.assertEquals("dd", "dd");
    }

    @Test
    public void test4() {
        Reporter.log("我自己的日志");
        throw new RuntimeException("我的异常");
    }

    @Test
    public void test5() {
        Assert.assertEquals("aa", "aa");
    }

    @Test
    public void test6() {
        Assert.assertEquals("aa", "bb");
    }

    @Test
    public void test7() {
        Assert.assertEquals("dd", "dd");
    }
}
