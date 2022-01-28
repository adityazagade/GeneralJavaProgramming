package main.java;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class HttpPostExample {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost req = new HttpPost("http://dummy.restapiexample.com/api/v1/create");
        String body = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
        try {
            StringEntity entity = new StringEntity(body);
            req.setEntity(entity);
            req.setHeader("Accept", "application/json");
            req.setHeader("Content-type", "application/json");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            CloseableHttpResponse res = client.execute(req);
            int statusCode = res.getStatusLine().getStatusCode();
            System.out.println("Status line: " + statusCode);
            if (statusCode == HttpURLConnection.HTTP_OK) {
                // read the response ..
                Scanner sc = new Scanner(res.getEntity().getContent());
                StringBuilder sb = new StringBuilder();
                while (sc.hasNext()) {
                    sb.append(sc.nextLine());
                }
                System.out.println(sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
