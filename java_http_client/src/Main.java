import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {
    static CookieManager ck = new CookieManager();

    public static void main(String[] args) {
        // Make a get call and fetch data ...
        // Using HttpUrlConncetion
        MakeGetCall();
        // Making a post call using HttpUrlConnection
        MakePost();

        //How to get cookies from response and put it on next requests.

    }

    private static void MakePost() {
        try {
            URL url = new URL("http://dummy.restapiexample.com/api/v1/create");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            // set headers
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "*");

            // adding cookies to request :
            con.setRequestProperty("Cookie", StringUtils.join(ck.getCookieStore().getCookies(), ";"));
            // set body
            //language=JSON
            String body = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
            OutputStream os = con.getOutputStream();
            os.write(body.getBytes());
            // read status code
            int resCode = con.getResponseCode();

            //read cookies from response ?
            String cookies = con.getHeaderField("Set-Cookie");
            List<HttpCookie> cs = HttpCookie.parse(cookies);
            //Need to keep this cookies somewhere .. Use CookieStore ...
            cs.forEach(cookie -> {
                ck.getCookieStore().add(null, cookie);
            });
//            for (HttpCookie c : cs) {
//                ck.getCookieStore().add(null, c);
//            }

            // check if any specific username is present ...
//            Optional<HttpCookie> usernameCookie = cookies.stream()
//                    .findAny().filter(cookie -> cookie.getName().equals("username"));
//            if (usernameCookie == null) {
//                cookieManager.getCookieStore().add(null, new HttpCookie("username", "john"));
//            }
//            Optional<HttpCookie> userNameCookie = cs.stream().findAny().filter(cookie ->
//                    cookie.getName().equals("username"));


            if (resCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
                br.close();
                System.out.println("Status code " + resCode);
                System.out.println(sb.toString());
            } else {
                System.out.println("Status code " + resCode);
            }
            //read response
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void MakeGetCall() {
        try {
            URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            System.out.println(sb.toString());
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
