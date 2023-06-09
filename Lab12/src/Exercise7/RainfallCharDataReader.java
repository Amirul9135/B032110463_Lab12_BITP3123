package Exercise7;

import java.io.BufferedReader; 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RainfallCharDataReader {
	
	public static void main(String [] args) {

		//declare filename
		String dataFileName = "dailyRainfallCharBased.txt";
		System.out.println("Reading rainfall data from " + dataFileName + "\n\n");
		
		//initialize variable
		String tmpDateString = "";
		int tmpRainFall = 0;
		double total = 0;
		int count = 0;
		try {
			
			//initialize input stream
			BufferedReader bfRainfall = new BufferedReader(new InputStreamReader(new FileInputStream(dataFileName)));
			
			//read and load data
			String areaName = bfRainfall.readLine();
			String line = "";
			
			while((line = bfRainfall.readLine()) != null) {
				String [] splittedStrings = line.split(" ");
				tmpRainFall = Integer.parseInt(splittedStrings[1]);
				tmpDateString = splittedStrings[0]; 
				total += tmpRainFall;
				count ++;
				
				System.out.println(tmpDateString + "\t: " + tmpRainFall);
			}
			
			//close stream
			bfRainfall.close();
			
			//calculate and display avrage
			System.out.println("Total Rainfall\t: " + total);
			System.out.printf("Average Rainfall in %s withtin the %d day is: %.4f", areaName,count ,(total / count));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
