package ss.week7.multiclientchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ASCIIProvider {
    private static final String API_URL = "http://artii.herokuapp.com/make?text=";

    public static void main (String args[]) {
        ASCIIProvider provider = new ASCIIProvider();

        try {
            String result = provider.generate("Testje");

            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Ascii failed \n");
        }
    }

    public String generate(String message) throws IOException{
        URL url = new URL(API_URL + message);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // execute the connection
        int status = connection.getResponseCode();

        // handle redirect
        if (status == HttpURLConnection.HTTP_MOVED_TEMP
                || status == HttpURLConnection.HTTP_MOVED_PERM) {
            String location = connection.getHeaderField("Location");
            URL newUrl = new URL(location);
            connection = (HttpURLConnection) newUrl.openConnection();
        }

        // read the response
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine + "\n");
        }
        // close the connection
        in.close();

        System.out.print(content.toString());
        System.out.flush();

        // return the content
        return content.toString();
    }
}