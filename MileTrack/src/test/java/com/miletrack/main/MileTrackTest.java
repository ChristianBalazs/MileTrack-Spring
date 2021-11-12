package com.miletrack.main;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import com.miletrack.main.domain.MileTrack;


public class MileTrackTest {

	
	
	@Test
	
	public void myMTGettersTest() {		
		MileTrack journeyTest = new MileTrack(1, "John", "estate", "diesel", 120, "business");
		assertEquals("Journey ID is: ", 1 , journeyTest.getJourneyId()); 
		assertEquals("Driver name is: ", "John" , journeyTest.getDriverName()); 
		assertEquals("Car type is: ", "estate" , journeyTest.getCarType()); 
		assertEquals("Fuel type is: ", "diesel" , journeyTest.getFuelType()); 
		assertEquals("Mileage done: ", 120 , journeyTest.getMilesDone()); 
		assertEquals("Journey type is: ", "business" , journeyTest.getJourneyType()); 
	}
	
	
	@Test
	public void myMTSettersTest() {
		MileTrack setterTest = new MileTrack(1, "John", "estate", "diesel", 120, "business");
		
		setterTest.setJourneyId(3);
		setterTest.setDriverName("Mary");
		setterTest.setCarType("SUV");
		setterTest.setFuelType("petrol");
		setterTest.setMilesDone(75);
		setterTest.setJourneyType("private");
		
		assertEquals("Journey ID is: ", 3 , setterTest.getJourneyId()); 
		assertEquals("Driver name is: ", "Mary" , setterTest.getDriverName()); 
		assertEquals("Car type is: ", "SUV" , setterTest.getCarType()); 
		assertEquals("Fuel type is: ", "petrol" , setterTest.getFuelType()); 
		assertEquals("Mileage done: ", 75 , setterTest.getMilesDone()); 
		assertEquals("Journey type is: ", "private" , setterTest.getJourneyType());				
	}
	
		
	
	
	
}
