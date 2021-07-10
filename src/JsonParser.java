import com.google.gson.Gson;

/**
 * Reads json file into coindesk object using gson.
 * @author David Cooksley
 *
 */
public class JsonParser {
	Gson gson;
	Coindesk coindesk; 
	public JsonParser(String json) {
		gson = new Gson();
		coindesk = gson.fromJson(json, Coindesk.class);
	}
	public Coindesk getCoindesk() {
		return coindesk;
	}
}
