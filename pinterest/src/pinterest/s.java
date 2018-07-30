package pinterest;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.io.*;

public class s {
	public static void main(String[] args) throws Exception{
		final URL url = new URL("https://www.pinterest.com/kidfreshfoods/pins?data=%7B%22options%22%3A%7B%22bookmarks%22%3A%5B%22Pz8yLjE0NTU1NjY3OTQuMjA4NDMyMjg4OTgyNjIwOTAwfDA0NDUzZGNhM2JhNDEzNjBjNTYwYjYwZjcxNDQ1OGJmZGJlOTc0OGJmZjFkZjZmNTM5YTIwZmNmZTdkNjQ1MWE%3D%22%5D%2C%22is_own_profile_pins%22%3Afalse%2C%22username%22%3A%22kidfreshfoods%22%7D%2C%22context%22%3A%7B%7D%7D&_=1490248484780");
		final HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
		urlConnection.setDoOutput(true);
		urlConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		urlConnection.connect();
		final OutputStream outputStream = urlConnection.getOutputStream();
		outputStream.write(("{\"fNamn\": \"" + stringData + "\"}").getBytes("UTF-8"));
		//System.out.println(stringData);
		outputStream.flush();
		//final InputStream inputStream = urlConnection.getInputStream();
		
		   

}
}
