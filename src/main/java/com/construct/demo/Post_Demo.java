package com.construct.demo;

import com.construct.parameterized.Read_Parameter;
import com.construct.util.ExcelUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Post_Demo {
    private static Logger log = Logger.getLogger(Test.class);

    @Test
    public void test_1() throws UnsupportedEncodingException {
        //声名post方法，获取测试url
        HttpPost post = new HttpPost("http://www.lemonban.com/user/ajax/login");
        //声名client对象，来执行请求
        HttpClient client = HttpClients.createDefault();
        //添加参数
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("account", "c17639617036"));
        params.add(new BasicNameValuePair("password", "czh_980405"));
       /* JSONObject jsonObject = new JSONObject();
        jsonObject.put("account", "c17639617036");
        jsonObject.put("password", "czh_980405");
        post.setEntity(new StringEntity(jsonObject.toString(),"utf-8"));*/
        //设置请求头信息
        post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        try {
            //通过client对象执行post方法
            HttpResponse response = client.execute(post);
            //接收返回结果
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            //将字符串结果转换为json,进行断言   这个为3层json
            JSONObject resultJson = new JSONObject(result);
            JSONObject entity = (JSONObject) (resultJson.get("entity"));
            System.out.println(entity);
            JSONObject user = (JSONObject) (entity.get("user"));
            System.out.println(user);

            String displayName = (String) (user.get("displayName"));

            Assert.assertEquals(displayName, "c17639617036");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test(description = "登录", dataProvider = "login", dataProviderClass = Read_Parameter.class)
    public void test_2(String describe, String account, String password) throws UnsupportedEncodingException {
        log.info("描述：" + describe + "账号：" + account + ";" + "密码：" + password);
        Reporter.log("描述：" + describe + ";账号：" + account + ";密码：" + password);
        //声名post方法，获取测试url
        HttpPost post = new HttpPost("http://www.lemonban.com/user/ajax/login");
        //声名client对象，来执行请求
        HttpClient client = HttpClients.createDefault();
        //添加参数
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("account", account));
        params.add(new BasicNameValuePair("password", password));
       /* JSONObject jsonObject = new JSONObject();
        jsonObject.put("account", "c17639617036");
        jsonObject.put("password", "czh_980405");
        post.setEntity(new StringEntity(jsonObject.toString(),"utf-8"));*/
        //设置请求头信息
        post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        try {
            //通过client对象执行post方法
            HttpResponse response = client.execute(post);
            //接收返回结果
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            //将字符串结果转换为json,进行断言   这个为3层json
            JSONObject resultJson = new JSONObject(result);
            JSONObject entity = (JSONObject) (resultJson.get("entity"));
            System.out.println(entity);
            JSONObject user = (JSONObject) (entity.get("user"));
            System.out.println(user);

            String displayName = (String) (user.get("displayName"));

            Assert.assertEquals(displayName, "c17639617036");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/*    @DataProvider(name = "login")
    public Object[][] dataS() {
        Object[][] dataS = {
                {"46465454", "czh_980405"},
                {"4648796123", "da4678135"},
                {"17639617036", "45464634"},
                {"17639617036", "czh_980405"},
                {"99999", "6786875678"}
        };

        return dataS;

    }*/

    @Test(description = "登录", dataProvider = "login_1", dataProviderClass = Read_Parameter.class)
    public void test_3(String account, String password) throws UnsupportedEncodingException {
        log.info("账号：" + account + ";" + "密码：" + password);
        Reporter.log(";账号：" + account + ";密码：" + password);
        //声名post方法，获取测试url
        HttpPost post = new HttpPost("http://www.lemonban.com/user/ajax/login");
        //声名client对象，来执行请求
        HttpClient client = HttpClients.createDefault();
        //添加参数
        List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("account", account));
        params.add(new BasicNameValuePair("password", password));
       /* JSONObject jsonObject = new JSONObject();
        jsonObject.put("account", "c17639617036");
        jsonObject.put("password", "czh_980405");
        post.setEntity(new StringEntity(jsonObject.toString(),"utf-8"));*/
        //设置请求头信息
        post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
        try {
            //通过client对象执行post方法
            HttpResponse response = client.execute(post);
            //接收返回结果
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
            //将字符串结果转换为json,进行断言   这个为3层json
            JSONObject resultJson = new JSONObject(result);
            JSONObject entity = (JSONObject) (resultJson.get("entity"));
            System.out.println(entity);
            JSONObject user = (JSONObject) (entity.get("user"));
            System.out.println(user);

            String displayName = (String) (user.get("displayName"));

            Assert.assertEquals(displayName, "c17639617036");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*@DataProvider(name = "ppp")
    public Object[][] dataS() {
        int[] rows = {2, 3, 4, 5, 6, 7};
        int[] cells = {6, 7};
        Object[][] dataS = ExcelUtil.DiscreteDataS("src/main/resources/TestCaseData/v1.xlsx", "sheet1", rows, cells);
        return dataS;
    }*/
}


