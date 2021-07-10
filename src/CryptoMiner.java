
public class CryptoMiner {
	private CurrencyRates rates;
	private Miner[] miners;
	private float[] powerRates;
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
		for (int i = 0; i < num; i++) {
			coinsPerHour += miners[i].getRate();
		}
		
		float coins;
		if (currency.equals("BTC")) coins = amount;
		else coins = amount/rates.getRate(currency);
		result.time = coins/coinsPerHour;
		int hours = (int)result.time;
		float decimalTime = result.time - hours;
		
		for (hours)
		return result;
	}
	
	public class CalculatedData {
		public float time; //h
		public float cost; //CAD
	}
	public int getNumberOfMiners() {
		return miners.length;
	}
}
