package Exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DailyRainfallDataReader {

	public static void main(String [] args) {

		String dataFileName = "dailyRainfallSimpangAmpat.txt";
		System.out.println("Reading rainfall data from " + dataFileName);
		
		String tmpDateString = "";
		int tmpRainFall = 0;
		try {
			DataInputStream disRainfall = new DataInputStream(new FileInputStream(dataFileName));
			
			String areaName = disRainfall.readUTF();
			
			while(disRainfall.available() > 0) {
				
				tmpDateString = disRainfall.readUTF();
				tmpRainFall = disRainfall.readInt();
				
				System.out.println(tmpDateString + "  : " + tmpRainFall);
			}
			
			disRainfall.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
