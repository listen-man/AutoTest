package com.httpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test() throws IOException {
        HttpGet getBaidu = new HttpGet("http://www.baidu.com");//get请求
        HttpResponse response = new DefaultHttpClient().execute(getBaidu);
        System.out.println(EntityUtils.toString(response.getEntity(),"UTF-8"));//将返回内容转换成字符串
    }
}
