package Exercise5;

import java.io.DataOutputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DailyRainfallDataGenerator {



	public static void main(String [] args) {

		String dataFileName = "dailyRainfallSimpangAmpat.txt";

		int dailyRainfall[] = {5,0,0,4,1,0};
		String rainfallDate [] = {"31/05/2023","01/06/2023","02/06/2023","03/06/2023","04/06/2023","05/06/2023"};


		try {
			DataOutputStream dosRainfall = new DataOutputStream(new FileOutputStream(dataFileName));



			dosRainfall.writeUTF("Simpang Ampat, Alor Gajah Melaka");
			for(int index=0;index < dailyRainfall.length; index++) {
				dosRainfall.writeUTF(rainfallDate[index]);
				dosRainfall.writeInt(dailyRainfall[index]);; 
			}

			System.out.println("Rainfall data saved into " + dataFileName);






		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
