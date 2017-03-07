package roma3.davorlando.traintonettuno.roma3.davorlando.traintonettuno.finder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by davideorlando on 07/03/17.
 */

public class HttpRequest {

    public static String doRequest(String urlRequest) {
        String response = null;
        try {
            URL request = new URL(urlRequest);
            URLConnection yc = request.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                response = inputLine;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
