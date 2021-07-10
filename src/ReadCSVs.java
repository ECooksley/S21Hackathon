import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Reads csv files with miner/power cost data.
 * @author David Cooksley
 *
 */
public class ReadCSVs {
	public static final String minersCSV = "MiningSetup.csv";
	public static final String powerCSV = "EnergyRates.csv";
	private Miner[] miners = new Miner[25];
	private float[] powerRates = new float[24];
	
	public ReadCSVs() {
		int minerCount = 0;
		try {
			Scanner sc1 = new Scanner(new File(minersCSV));
			while (sc1.hasNextLine()) {
				String line = sc1.nextLine();
				Scanner sc2 = new Scanner(line);
				sc2.useDelimiter(",");
				sc2.next(); //don't care about name
				float rate = sc2.nextFloat();
				float wattage = sc2.nextFloat();
				miners[minerCount] = new Miner(rate,wattage);
				minerCount++;
				sc2.close();
			}
			sc1.close();
			
			Miner[] temp = new Miner[minerCount];
			for (int i = 0; i < minerCount; i++) {
				temp[i] = miners[i];
			}
			miners = temp;
			
			
			sc1 = new Scanner(new File(powerCSV));
			int hour = 0;
			while (sc1.hasNextLine()) {
				String line = sc1.nextLine();
				Scanner sc2 = new Scanner(line);
				sc2.useDelimiter(",");
				sc2.next(); //hour is captured by index
				powerRates[hour] = sc2.nextFloat();
				hour++;
				sc2.close();
			}
			sc1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Miner[] getMiners() {
		return miners;
	}
	
	public float[] getPowerRates() {
		return powerRates;
	}
}
