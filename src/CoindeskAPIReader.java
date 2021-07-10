import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class CoindeskAPIReader {
	private URL url;
	private static final String API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
	private HttpURLConnection conn;
	String apiData;
	public CoindeskAPIReader() {
		try {
			url = new URL(API_URL);
			
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			} else {
				Scanner sc = new Scanner(url.openStream());
				apiData = sc.nextLine();
				sc.close();
			}
			System.out.println(apiData);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new CoindeskAPIReader();
	}
}
