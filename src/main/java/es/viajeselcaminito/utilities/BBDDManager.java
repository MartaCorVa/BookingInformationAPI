package es.viajeselcaminito.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BBDDManager {

    private URL url;

    public BBDDManager(URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public String getAllHotels(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int status = connection.getResponseCode();

        if ( status == HttpURLConnection.HTTP_OK ) {
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            StringBuffer content = new StringBuffer();
            while ((inputLine = input.readLine()) != null) {
                content.append(inputLine);
            }
            input.close();
            connection.disconnect();

            return content.toString();
        }

        return null;

    }

}
