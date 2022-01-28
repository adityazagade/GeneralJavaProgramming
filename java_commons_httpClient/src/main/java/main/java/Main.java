package main.java;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();

        // make a get request
        HttpGet req = new HttpGet("https://www.goal.com/en-in");

        try {
            HttpResponse res = client.execute(req);
            StatusLine statusCode = res.getStatusLine();
            System.out.println("Status code : " + statusCode.getStatusCode());

            // read the response..
            BufferedReader br = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Making a get call using apache http client ...
}
