package main.java;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HttpPostURLEncodedFormEntity {
    //    make a POST call to
    //    https://www.baeldung.com/httpclient-post-http-request
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://www.example.com");
        List<NameValuePair> queryParams = new ArrayList<NameValuePair>();
        queryParams.add(new BasicNameValuePair("username", "John"));
        queryParams.add(new BasicNameValuePair("Pass", "pass"));

        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(queryParams);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        post.setEntity(entity);
        try {
            client.execute(post);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
