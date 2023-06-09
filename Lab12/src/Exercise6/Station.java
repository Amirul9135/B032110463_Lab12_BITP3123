package Exercise6;

public class Station {

	private String stationId;
	private String stationName;
	private String district;
	private int [] rainfalls;
	private String[] rainfallsDate;
	
	public Station(String stationId, String stationName, String district, int[] rainfalls, String[] rainfallsDate) {
		this.stationId = stationId;
		this.stationName = stationName;
		this.district = district;
		this.rainfalls = rainfalls;
		this.rainfallsDate = rainfallsDate;
	}
	
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int[] getRainfalls() {
		return rainfalls;
	}
	public void setRainfalls(int[] rainfalls) {
		this.rainfalls = rainfalls;
	}

	public String[] getRainfallsDate() {
		return rainfallsDate;
	}

	public void setRainfallsDate(String[] rainfallsDate) {
		this.rainfallsDate = rainfallsDate;
	}
	
	
	
}
