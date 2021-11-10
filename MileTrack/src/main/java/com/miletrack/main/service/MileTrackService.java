package com.miletrack.main.service;

import java.util.List;

import com.miletrack.main.domain.MileTrack;



//Role: Interface to define CRUD methods used for communication with front end 

public interface MileTrackService {

	//Create Journey(object) method
	MileTrack createJourney(MileTrack newMileTrack);
	
	//Read all journeys method
	List<MileTrack> getAllJourneys();
	
	//Read a specific journey
	MileTrack getJourney(Integer id);
	
	//Update the record for one journey with new object variables
	MileTrack replaceJourney(Integer id, MileTrack newMileTrack);
			
	//Delete a journey from DB
	boolean removeJourney(Integer id);
	
	
	
}
