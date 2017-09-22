/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex20;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/**
 *
 * @author Alexander
 */
public class MyCallable implements Callable<String> {

    String url;

    public MyCallable(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        return getStatus(url);
    }

    public static String getStatus(String url) throws IOException {

        String result = "Error";
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                result = "Green";
            }
            if (code == 301) {
                result = "Redirect";
            }
        } catch (Exception e) {
            result = "->Red<-";
        }
        return result;
    }
}
