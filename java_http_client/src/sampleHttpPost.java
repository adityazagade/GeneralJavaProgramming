import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Need to check how to add Cookies to the request. Might have to extract cookies from the response first and then add it request next time onwards ...
//https://www.baeldung.com/java-http-request

public class sampleHttpPost {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://dummy.restapiexample.com/api/v1/create");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //If you want to set request parameters or (I think even send anything using outputstream), setDoOutput = true;
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            // set headers if you want to set them ..
            con.setRequestProperty("Content-Type", "application/json");
            // how to read headers?
            //  con.getRequestProperty("Content-Type")

            //setting timeouts
            con.setReadTimeout(5000);
            con.setConnectTimeout(5000);

            // set the body ...
            OutputStream os = con.getOutputStream();
            String body = "{\"name\":\"test1\",\"salary\":\"123\",\"age\":\"23\"}";
            os.write(body.getBytes());
            os.flush();
            os.close();
            int statusCode = con.getResponseCode();
            if(statusCode == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line;
                while((line = br.readLine()) != null){
                    sb.append(line);
                }
                br.close();
                System.out.println(sb.toString());
            } else {
                System.out.println("statusCode " + statusCode);
                System.out.println("Some error occurred");
            }
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
