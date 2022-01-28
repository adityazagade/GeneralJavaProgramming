package main.java;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Scanner;

public class HttpGetClient {
    //    https://www.tutorialspoint.com/apache_httpclient/apache_httpclient_user_authentication.htm
    //    https://www.baeldung.com/httpclient-guide
    public static void main(String[] args) {
        // first create ClosableHttpClient
        //Create the get request
        //make the call
        //read the response

        //  We can use this to make a call to any URL. In this case we will make a GET call to a REST endpoint.
        //  http://dummy.restapiexample.com/api/v1/employees
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet req = new HttpGet("http://dummy.restapiexample.com/api/v1/employees");
        System.out.println("Method: " + req.getMethod());

        try {
            HttpResponse res = client.execute(req);
            Scanner s = new Scanner(res.getEntity().getContent());
            System.out.println("Status code : " + res.getStatusLine());
            while (s.hasNext()) {
                System.out.println(s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}