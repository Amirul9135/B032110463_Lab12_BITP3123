package Exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream; 
import java.io.IOException;

public class DailyRainfallDataReader {

	public static void main(String [] args) {

		//declare file name
		String dataFileName = "dailyRainfallSimpangAmpat.txt";
		System.out.println("Reading rainfall data from " + dataFileName + "\n\n");
		
		//initialize variable
		String tmpDateString = "";
		int tmpRainFall = 0;
		double total = 0;
		int count = 0;
		try {
			
			//initialize input stream
			DataInputStream disRainfall = new DataInputStream(new FileInputStream(dataFileName));
			
			//read and load data
			String areaName = disRainfall.readUTF();
			
			while(disRainfall.available() > 0) {
				
				tmpDateString = disRainfall.readUTF();
				tmpRainFall = disRainfall.readInt();
				total += tmpRainFall;
				count ++;
				
				System.out.println(tmpDateString + "\t: " + tmpRainFall);
			}
			
			//close stream
			disRainfall.close();
			
			//calculate and display avrage
			System.out.println("Total Rainfall\t: " + total);
			System.out.printf("Average Rainfall in %s withtin the %d day is: %.4f", areaName,count ,(total / count));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
