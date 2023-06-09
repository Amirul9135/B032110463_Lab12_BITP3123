package Exercise5;

import java.io.DataOutputStream;  
import java.io.FileOutputStream; 

public class DailyRainfallDataGenerator {



	public static void main(String [] args) {

		//declare filename
		String dataFileName = "dailyRainfallSimpangAmpat.txt";

		//load data into variable
		int dailyRainfall[] = {5,0,0,4,1,0};
		String rainfallDate [] = {"31/05/2023","01/06/2023","02/06/2023","03/06/2023","04/06/2023","05/06/2023"};


		try {
			
			//initialize stream
			DataOutputStream dosRainfall = new DataOutputStream(new FileOutputStream(dataFileName));
			
			
			//write all data
			dosRainfall.writeUTF("Simpang Ampat, Alor Gajah Melaka");
			for(int index=0;index < dailyRainfall.length; index++) {
				dosRainfall.writeUTF(rainfallDate[index]);
				dosRainfall.writeInt(dailyRainfall[index]);; 
			}

			System.out.println("Rainfall data saved into " + dataFileName);
			
			//close stream
			dosRainfall.close();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
