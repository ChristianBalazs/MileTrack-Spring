package com.miletrack.main.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.miletrack.main.domain.MileTrack;
import com.miletrack.main.repos.MileTrackRepo;


//Role: business logic to work with database
//implement MileTrackService interface

//Use @Service annotation 
//@Service annotation is used with classes that provide business functionalities
//Spring boot will autodetect these classes when 
//annotation-based configuration and classpath scanning is used

@Service
public class MileTrackServiceDB implements MileTrackService {

	//After implementing - populate with methods from the interface
	//will generate the body for each method
	
	//Created an object(?) of MileTrackRepo interface, called mtRepo
	private MileTrackRepo mtRepo;
		
	
	//Created constructor using mtRepo 
	public MileTrackServiceDB(MileTrackRepo mtRepo) {
		super();
		this.mtRepo = mtRepo;
	}

	
	//set up response for when running createJourney() method
	@Override
	public MileTrack createJourney(MileTrack newMileTrack) {		
		return this.mtRepo.save(newMileTrack);
	}

	
	//set up response for when running getAllJourneys() method
	@Override
	public List<MileTrack> getAllJourneys() {		
		return this.mtRepo.findAll();
	}

	
	//set up response for when running getJourney() method
	@Override
	public MileTrack getJourney(Integer id) {		
		java.util.Optional<MileTrack> mtOptional = this.mtRepo.findById(id);
		
		if (mtOptional.isPresent()) {
			MileTrack journeyResponse = mtOptional.get();
			return journeyResponse;
		}else {
			throw new EntityNotFoundException("No journey found with id: " + id);
		}
		
	}

	
	//set up response for when running replaceJourney() method
	@Override
	public MileTrack replaceJourney(Integer id, MileTrack newMileTrack) {
		MileTrack currentJourney = this.getJourney(id);
		
		currentJourney.setDriverName(newMileTrack.getDriverName());
		currentJourney.setCarType(newMileTrack.getCarType());
		currentJourney.setFuelType(newMileTrack.getFuelType());
		currentJourney.setJourneyType(newMileTrack.getJourneyType());
		currentJourney.setMilesDone(newMileTrack.getMilesDone());
		
		return this.mtRepo.save(currentJourney);
	}
	
	
	
	//set up response for when running removeJourney() method
	@Override
	public boolean removeJourney(Integer id) {
		this.mtRepo.deleteById(id);
		return !this.mtRepo.existsById(id);
	}

		
	
	
	
}
