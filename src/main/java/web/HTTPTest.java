package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HTTPTest {

    public static String readString () {
        String line = "";
        BufferedReader R = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            line = R.readLine();
        }
        catch (IOException e) { System.out.println("Error:" + e.toString()); }
        return line;
    }

    public static void main(String[] args) throws IOException {
        URL url = null;
        try {
            url = new URL("https://www.nytimes.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //con.setRequestMethod("GET");
            con.setRequestMethod("HEAD");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        try {
            int status = con.getResponseCode();
            System.out.println("result: " + status);

        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        con.disconnect();

        System.out.println("result: " + content.toString());
    }

    public static String read() {
        String input = "";
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}
