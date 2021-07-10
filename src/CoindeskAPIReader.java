import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


/**
 * Reads data from coindesk API. URL accessing code from:
 * 
 * [1]"Getting JSON Data From a RESTful API Using JAVA", Medium, 2021. [Online]. 
 * Available: https://medium.com/swlh/getting-json-data-from-a-restful-api-using-java-b327aafb3751. 
 * [Accessed: 10- Jul- 2021]
 * 
 * @author David Cooksley
 *
 */
public class CoindeskAPIReader {
	
	private URL url;
	private static final String API_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
	private HttpURLConnection conn;
	private String apiData;
	

	/**
	 * Constructor. Pulls data from coindesk api and saves json string.
	 */
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
	
	/**
	 * Getter for api data.
	 * @return String: apiData
	 */
	public String getAPIData() {
		return apiData;
	}
}
