package Exercise7;
 
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class RainfallCharDataGenerator {
	
	
	public static void main(String [] args) {

		//declare filename
		String dataFileName = "dailyRainfallCharBased.txt";

		//load data into variable
		int dailyRainfall[] = {5,0,0,4,1,0};
		String rainfallDate [] = {"31/05/2023","01/06/2023","02/06/2023","03/06/2023","04/06/2023","05/06/2023"};


		try {
			
			//initialize stream
			PrintWriter pwRainfall = new PrintWriter(new FileOutputStream(dataFileName));
			
			
			//print all data
			pwRainfall.println("Simpang Ampat, Alor Gajah Melaka");
			for(int index=0;index < dailyRainfall.length; index++) {
				pwRainfall.print(rainfallDate[index] + " ");
				pwRainfall.println(dailyRainfall[index]);; 
			}

			System.out.println("Rainfall data saved into " + dataFileName);
			
			//close stream
			pwRainfall.close();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
