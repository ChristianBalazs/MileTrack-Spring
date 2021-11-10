package com.miletrack.main.domain;


//Role : Default Constructor with Getters and Setters

public class MileTrack {

	
	//Defined private variables for object creation 
	private String driverName;
	
	private String carType;
	
	private boolean isFuelDiesel;
	
	private int milesDone;
		
	private boolean isBusinessMiles;

	
	
	//Defined constructor for objects
	public MileTrack(String driverName, String carType, boolean isFuelDiesel, int milesDone, boolean isBusinessMiles) {
		super();
		this.driverName = driverName;
		this.carType = carType;
		this.isFuelDiesel = isFuelDiesel;
		this.milesDone = milesDone;
		this.isBusinessMiles = isBusinessMiles;
	}

	
	
	//Created Getters and Setters for all 5 variables
	public String getDriverName() {
		return driverName;
	}


	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	public String getCarType() {
		return carType;
	}


	public void setCarType(String carType) {
		this.carType = carType;
	}


	public boolean isFuelDiesel() {
		return isFuelDiesel;
	}


	public void setFuelDiesel(boolean isFuelDiesel) {
		this.isFuelDiesel = isFuelDiesel;
	}


	public int getMilesDone() {
		return milesDone;
	}


	public void setMilesDone(int milesDone) {
		this.milesDone = milesDone;
	}


	public boolean isBusinessMiles() {
		return isBusinessMiles;
	}


	public void setBusinessMiles(boolean isBusinessMiles) {
		this.isBusinessMiles = isBusinessMiles;
	}
	
	
	
	
	
	
	
	
}
