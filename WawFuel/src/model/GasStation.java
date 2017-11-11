package model;

public class GasStation {

	private int idStation;
	private String stationBrand;
	private String address;
	private String fuelType;
	private String price;
	private String date;
	private int  rate;
		
	public GasStation() {
		super();
	}
	public GasStation(int idStation, String stationBrand, String address, String fuelType, String price, String date) {
		super();
		this.idStation = idStation;
		this.stationBrand = stationBrand;
		this.address = address;
		this.fuelType = fuelType;
		this.price = price;
		this.date = date;
	}
	
	public GasStation(int idStation, String stationBrand, String address, String fuelType, String price, String date, int rate) {
		super();
		this.idStation = idStation;
		this.stationBrand = stationBrand;
		this.address = address;
		this.fuelType = fuelType;
		this.price = price;
		this.date = date;
		this.rate = rate;
	}
	
	
	
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getIdStation() {
		return idStation;
	}
	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}
	public String getStationBrand() {
		return stationBrand;
	}
	public void setStationBrand(String stationBrand) {
		this.stationBrand = stationBrand;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return  idStation + "," + stationBrand + "," + address
				+ "," + fuelType + "," + price + "," + date + "," + rate + "\n";
	}
	
}
