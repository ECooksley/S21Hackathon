
/**
 * Represents a BTC miner
 * @author David Cooksley
 *
 */
@SuppressWarnings("rawtypes")
public class Miner implements Comparable {
	private float rate; // BTC/h
	private float wattage; // kW
	
	
	public Miner(float r, float w) {
		rate = r;
		wattage = (float)(w/1000.0);
	}
	public float getRate() {
		return rate;
	}
	public float getWattage() {
		return wattage;
	}
	@Override
	public int compareTo(Object o) {
		Miner otherMiner = (Miner)o;
		Float coinRate = wattage/rate;
		return coinRate.compareTo((otherMiner.getWattage()/otherMiner.getRate()));
	}
}
