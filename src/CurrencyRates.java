
/**
 * Does all API reading and collects all currency data and time of access in one place.
 * @author David Cooksley
 *
 */
public class CurrencyRates {
	private float USD;
	private float GBP;
	private float EUR;
	private float CAD;
	private int hour;
	public static final String COINDESK_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";
	public static final String CAD_URL = "https://api.coindesk.com/v1/bpi/currentprice/CAD.json";	
	private CoindeskAPIReader apiReader;
	private JsonParser jsonParser;
	private Coindesk coindesk;
	
	/**
	 * Accesses APIs and pulls currency rate data.
	 */
	public CurrencyRates() {
		apiReader = new CoindeskAPIReader(COINDESK_URL);
		String json = apiReader.getAPIData();
		jsonParser = new JsonParser(json);
		coindesk = jsonParser.getCoindesk();
		USD = coindesk.getRate("USD");
		GBP = coindesk.getRate("GBP");
		EUR = coindesk.getRate("EUR");
		hour = coindesk.getHour();
		apiReader = new CoindeskAPIReader(CAD_URL); //CAD data is on second API page, so second object is necessary
		json = apiReader.getAPIData();
		jsonParser = new JsonParser(json);
		coindesk = jsonParser.getCoindesk();
		CAD = coindesk.getRate("CAD");
	}
	
	/**
	 * @param currency
	 * @return float: BTC rate in given currency
	 */
	public float getRate(String currency) {
		switch (currency) {
		case "USD": return USD;
		case "GBP": return GBP;
		case "EUR": return EUR;
		case "CAD": return CAD;
		default: return 0;
		}
	}
	
	/**
	 * @return int: hour api was accessed.
	 */
	public int getHour() {
		return hour;
	}
}
