package pinterest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;


public class SyncCrawl {
    
    public static String getMethod(String urlstring,boolean redirect) throws IOException {
        
        URL url = new URL(urlstring);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setInstanceFollowRedirects( redirect );
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json, text/javascript, */*");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.8");
        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        con.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/53.0.2785.143 Chrome/53.0.2785.143 Safari/537.36");
        con.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder responseBuilder = new StringBuilder();
        String chunk;
        while ((chunk = br.readLine()) != null) {
                    responseBuilder.append(chunk);
        }            
        String responseData = responseBuilder.toString();
        if(con.getResponseCode() == 200) {
                //crawlurl.setCrawlerState("Success");
        }
        else {
                //crawlurl.setCrawlerState("Failed");
                responseData="";
        }
        con.disconnect();
        return responseData;
        }

}