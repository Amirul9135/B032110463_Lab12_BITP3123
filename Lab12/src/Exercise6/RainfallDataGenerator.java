package Exercise6;

import java.io.DataOutputStream; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RainfallDataGenerator {

	public static void main(String [] args) {

		//declaration of the filename to store the data in
		String filename = "RainfallDataByStation.txt"; 
		
		//load ada for 2 station in each district into array list
		ArrayList<Station> stations = new ArrayList<>();
		
		stations.add(new Station("2322006", "Melaka Pindah", "Alor Gajah",
				new int[]{0,0,0,2,18,2},
				new String[]{"03/06/2023","04/06/2023","05/06/2023","06/06/2023","07/06/2023","08/06/2023"}));
		
		stations.add(new Station("2321006", "Ladang Lendu", "Alor Gajah",
				new int[]{2,0,0,3,4,0},
				new String[]{"03/06/2023","04/06/2023","05/06/2023","06/06/2023","07/06/2023","08/06/2023"}));

		stations.add(new Station("2324033", "Hospital Jasin", "Jasin",
				new int[]{0,14,0,11,15,31},
				new String[]{"03/06/2023","04/06/2023","05/06/2023","06/06/2023","07/06/2023","08/06/2023"})); 
		
		stations.add(new Station("2125002", "Telok Rimba", "Jasin",
				new int[]{0,1,1,69,53,4},
				new String[]{"03/06/2023","04/06/2023","05/06/2023","06/06/2023","07/06/2023","08/06/2023"}));
		 
		stations.add(new Station("0300061RF", "Bukit Katil, Sg. Duyong", "Melaka Tengah",
				new int[]{0,1,0,38,24,58},
				new String[]{"03/06/2023","04/06/2023","05/06/2023","06/06/2023","07/06/2023","08/06/2023"}));
		 
		stations.add(new Station("2222033", "Batu Hampar", "Melaka Tengah",
				new int[]{0,3,0,30,12,22},
				new String[]{"03/06/2023","04/06/2023","05/06/2023","06/06/2023","07/06/2023","08/06/2023"}));
		//data loading ends
		
		try {
			
			//initialize output stream 
			DataOutputStream dosRainfall = new DataOutputStream(new FileOutputStream(filename));
			
			//loop through each station
			for(Station station : stations) {
				
				//write the station district,id and name as a single string separated by |
				dosRainfall.writeUTF(station.getDistrict()+"|"+station.getStationId()+"|"+station.getStationName());
				
				//writes the number of rainfall data for reference of reader looping 
				dosRainfall.writeInt(station.getRainfalls().length);
				
				//loop through the rainfall reading and write each of it along with date
				for(int index =0;index < station.getRainfalls().length; index++) {
					
					dosRainfall.writeUTF(station.getRainfallsDate()[index]);
					dosRainfall.writeInt(station.getRainfalls()[index]);
				}
			}
			
			//close the output stream
			dosRainfall.close();
			
			System.out.println("Rainfall data for 2 station in each district within Melaka saved in\n" + filename);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
