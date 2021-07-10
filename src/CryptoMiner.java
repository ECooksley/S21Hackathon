
public class CryptoMiner {
	private CurrencyRates rates;
	private Miner[] miners;
	private float[] powerRates; // CAD/kWh
	public CryptoMiner() {
		rates = new CurrencyRates();
		ReadCSVs csvData = new ReadCSVs();
		miners = csvData.getMiners();
		powerRates = csvData.getPowerRates();
	}
	
	/**
	 * @param amount: float number of bitcoin
	 * @param num: int number of miners
	 * @param currency: 
	 * @return
	 */
	public CalculatedData calcData(float amount, int num, String currency) {
		CalculatedData result = new CalculatedData();
		float coinsPerHour = 0;
		float totalWattage = 0;
		for (int i = 0; i < num; i++) {
			coinsPerHour += miners[i].getRate();
			totalWattage += miners[i].getWattage();
		}
		
		float coins;
		if (currency.equals("BTC")) coins = amount;
		else coins = amount/rates.getRate(currency);
		result.time = coins/coinsPerHour;
		int hours = (int)result.time;
		float decimalTime = result.time - hours;
		float cost = 0;
		int hour = rates.getHour();
		for (int i = hours; i > 0; i--) {
			cost += powerRates[hour]*totalWattage;
			hour += 1;
			hour = hour%24;
		}
		cost += powerRates[hour]*totalWattage*decimalTime;
		result.cost = cost;
		result.coinsBTC = coins;
		result.coinsUSD = coins*rates.getRate("USD");
		result.coinsGBP = coins*rates.getRate("GBP");
		result.coinsEUR = coins*rates.getRate("EUR");
		result.coinsCAD = coins*rates.getRate("CAD");
		return result;
	}
	
	public int getNumberOfMiners() {
		return miners.length;
	}
}
