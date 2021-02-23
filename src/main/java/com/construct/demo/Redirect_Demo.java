package com.construct.demo;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
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

/**
 * 重定向 测试demo
 */
public class Redirect_Demo {

    public static void main(String[] args) {
        HttpPost post = new HttpPost("http://114.55.105.91/wp-blog/wp-login.php");
        HttpClient client = HttpClients.createDefault();
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("log", "chengzhihao"));
        parameters.add(new BasicNameValuePair("pwd", "czh04055."));
        try {
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(parameters, "utf-8");
            post.setEntity(urlEncodedFormEntity);
            try {
                HttpResponse response = client.execute(post);
                int code = response.getStatusLine().getStatusCode();
                String newuri="";
                if (code == 302) {
                    Header header = response.getFirstHeader("location");// 跳转的目标地址是在 HTTP-HEAD 中的
                    System.out.println("head"+header);
                    newuri = header.getValue(); // 这就是跳转后的地址，再向这个地址发出新申请，以便得到跳转后的信息是啥。
                    System.out.println(newuri);
                    System.out.println(code);
                    post = new HttpPost(newuri);
                    response = client.execute(post);
                }
                HttpEntity entity  = response.getEntity();
                String s2 = EntityUtils.toString(entity, "UTF-8");
                System.out.println(s2);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
