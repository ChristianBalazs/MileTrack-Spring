package com.miletrack.main.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Role : Default Constructor with Getters and Setters

//Import @Entity for this class
//An entity represents a table stored in a database. 
//Every instance of an entity represents a row in the table


@Entity
public class MileTrack {

	//Defined private variables for object creation 
	
	//Imported @Id - to use as Primary Key for table rows
	//Import @GeneratedValue - to auto increment each primary key
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private int journeyId;//added during H2 DB test 
	
	private String driverName;
	
	private String carType;
	
	private String fuelType;
	
	private int milesDone;
		
	private String journeyType;
	
	//NOTE:
	//Create Default constructor ONLY for the use of Hibernate
	//Hibernate uses the default constructor to create entity objects.
	
	public MileTrack(){
		super();
	}
	
	
	
	//Defined constructor for objects
	public MileTrack(int journeyId, String driverName, String carType, String fuelType, int milesDone, String journeyType) {
		super();
		this.journeyId=journeyId;
		this.driverName = driverName;
		this.carType = carType;
		this.fuelType = fuelType;
		this.milesDone = milesDone;
		this.journeyType = journeyType;
	}


	//Created Getters and Setters for all 5 variables
	
	public int getJourneyId() {
		return journeyId;
	}



	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}



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



	public String getFuelType() {
		return fuelType;
	}



	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}



	public int getMilesDone() {
		return milesDone;
	}



	public void setMilesDone(int milesDone) {
		this.milesDone = milesDone;
	}



	public String getJourneyType() {
		return journeyType;
	}



	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
	}

	
	
	
	
	
	
	
	
}
