
/**
 * Class based on json return from coindesk api.
 * @author David Cooksley
 *
 */
public class Coindesk {
	private Time time;
	private String disclaimer;
	private String chartName;
	private BPI bpi;

	private class Time {
		private String updated;
		private String updatedISO;
		private String updateduk;
	}
	
	private class BPI {
		private Currency USD;
		private Currency GBP;
		private Currency EUR;
		private Currency CAD;
	}
	
	private class Currency {
		private String code;
		private String symbol;
		private String rate;
		private String description;
		private float rate_float;
	}
	
	/**
	 * @param currency
	 * @return float: BTC rate in given currency
	 */
	public float getRate(String currency) {
		switch (currency) {
		case "USD": return bpi.USD.rate_float;
		case "GBP": return bpi.GBP.rate_float;
		case "EUR": return bpi.EUR.rate_float;
		case "CAD": return bpi.CAD.rate_float;
		default: return 0;
		}
	}

}