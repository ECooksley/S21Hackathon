
/**
 * Represents a BTC miner
 * @author David Cooksley
 *
 */
public class Miner {
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
}
