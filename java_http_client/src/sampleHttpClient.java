import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class sampleHttpClient {
    public static void main(String[] args) {
        // Make a get CALL to the endpoint and print the data
        //
        try {
            URL url = new URL("http://dummy.restapiexample.com/api/v1/employees");
            System.out.println("host " + url.getHost());
            System.out.println(url.getPath());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            int statusCode = con.getResponseCode();
            if (statusCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Some error occurred: " + statusCode);
            } else {
                //read the response and print it here ...
                BufferedReader is = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer sb = new StringBuffer();
                while ((inputLine = is.readLine()) != null) {
                    sb.append(inputLine);
                }
                is.close();
                System.out.println(sb.toString());
                con.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
