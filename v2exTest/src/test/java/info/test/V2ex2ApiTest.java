package info.test;

import com.alibaba.fastjson.JSON;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class V2ex2ApiTest {
    public static final String[] nodeNames = {"java", "python", "php", "c"};
    public static final String url = "https://www.v2ex.com/api/nodes/show.json?name=";

    @Test
    public void nodeApi() throws IOException {

        OkHttpClient client = new OkHttpClient();
        for (String nodeName : nodeNames) {
            Request request = new Request.Builder()
                    .url(url + nodeName)
                    .get()
                    .build();
            Response response = client.newCall(request).execute();
            V2exNode node = JSON.parseObject(response.body().string(), V2exNode.class);
            System.out.println(node.getName()+"---"+nodeName);
            Assert.assertEquals(node.getName(),nodeName);
        }
//                .addHeader("User-Agent", "PostmanRuntime/7.15.0")
//                .addHeader("Accept", "*/*")
//                .addHeader("Cache-Control", "no-cache")
//                .addHeader("Postman-Token", "700f0649-322e-45ca-aa81-a3a2ca4ecb6d,d98806bf-51f6-4100-9144-22ad9930bb49")
//                .addHeader("Host", "www.v2ex.com")
//                .addHeader("cookie", "__cfduid=d5eb1cc114fca91a5620615e165e40c111562642398; PB3_SESSION='2|1:0|10:1562642566|11:PB3_SESSION|40:djJleDoxMTMuMTAyLjE2Ny4xNTc6NzMxOTQ4MTY=|a2cf3b0361dc11eeee12841e66b7dd875dd64d4c830e725b5ae0b60f7b689049'; V2EX_LANG=zhcn")
//                .addHeader("accept-encoding", "gzip, deflate")
//                .addHeader("Connection", "keep-alive")
//                .addHeader("cache-control", "no-cache")

    }
}
