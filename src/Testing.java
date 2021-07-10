import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
public class Testing {
	public static void main(String[] args) {
		int test;
		test = 10;
		test +=10;
		try {
			URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
		
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
		
			int responsecode = conn.getResponseCode();
			
			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			} else {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				
				while(sc.hasNext()) {
					inline += sc.nextLine();
				}
				
				sc.close();
				
				System.out.println(inline);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
