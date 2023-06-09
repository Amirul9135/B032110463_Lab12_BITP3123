package Exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.ArrayList; 

public class RainfallDataReader {

	public static void main(String [] args) {

		//declaration of the filename to read the data from
		String filename = "RainfallDataByStation.txt"; 
		
		try {
			
			//initialize input stream
			DataInputStream disRainfall = new DataInputStream(new FileInputStream(filename)); 
			
			//initialize variables
			int stationCount = 0;
			
			//array to contain the name of distinct district
			ArrayList<String> districts = new ArrayList<>();
			String tmpStationString = ""; 
			
			//read through the file
			while(disRainfall.available() > 0) { 
				
				//read the string and split by |
				tmpStationString = disRainfall.readUTF(); 
				String [] stationDetail = tmpStationString.split("\\|");  
				
				//checks if district name already exist in the array of district name
				boolean alreadyExist = false;
				for(String districtName : districts) {
					if(districtName.equals(stationDetail[0])) {
						alreadyExist = true;
						break;
					}
						
				}
				
				//add the district name if its not yet in the array
				if(!alreadyExist)
					districts.add(stationDetail[0]);
				
				//print the station details
				System.out.printf("District:%s\nStation Id: %s\tStation Name: %s\n", stationDetail[0],stationDetail[1],stationDetail[2]);
				
				//read the number of rainfall and loop through to read all value
				int rainfallCount = disRainfall.readInt();
				double total =0;
				for(int index =0; index < rainfallCount;index++) {
					String date = disRainfall.readUTF();
					int value = disRainfall.readInt();
					System.out.println(date + "\t: " + value);
					total+= value;

				}
				
				//calculate average increment station count
				System.out.printf("Average Rainfall\t: %.4f\n", (total/rainfallCount));
				System.out.println("__________________________________________________________________");
				stationCount++;
				
			}
			
			System.out.printf("\nNumber of stations:%d\nNumber of District:%d\n", stationCount, districts.size());
			System.out.println("__________________________________________________________________");
			
			//close input stream
			disRainfall.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
