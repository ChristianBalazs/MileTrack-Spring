package com.miletrack.main.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miletrack.main.domain.MileTrack;
import com.miletrack.main.service.MileTrackService;

//Role: Communicates with front end via GET/POST requests
//      Receives requests and sends responses 


//Added @RestController annotation to enable request handling
//Added @RequestMapping - 
//It maps HTTP requests to handler methods of MVC and REST controllers.

@RestController
@RequestMapping
public class MileTrackController {

	//Create a variable from MileTrackService interface, called MTservice
	private MileTrackService MTservice;
	
	
	
	//Create a constructor using that variable 
	public MileTrackController(MileTrackService mTservice) {
		super();
		MTservice = mTservice;
	}
	
	
	//Create listener for GET request
	//Return response as type string  
	@GetMapping("/hello")
	public String welcome() {
		return "Welcome to MileTrack Application!"; 
	}
	
	
	//Create listener for POST request
	//ResponseEntity represents an HTTP response, including headers, body, and status
	//Return a response by creating a new journey
	@PostMapping("/record")
	public ResponseEntity<MileTrack> createJourney(@RequestBody MileTrack newMileTrack){
		MileTrack responseBody = this.MTservice.createJourney(newMileTrack);
		return new ResponseEntity<MileTrack>(responseBody, HttpStatus.CREATED);		
	} 
	
	
	//Listener for GET request
	//Created a ResponseEntity to respond by creating a list 
	//Run getAllJourney() method, place it inside this list and return to Front End
	@GetMapping("/getAllJourneys")
	public ResponseEntity <List<MileTrack>> getAllJourneys(){
		return ResponseEntity.ok(this.MTservice.getAllJourneys());
	}
	
	
	//Listener for GET request
	//Use @PathVariable to ensure id parameter of getJourney()method is the {id} from URL of request
	//Return a journey with relevant id
	@GetMapping("getJourney/{idGet}")
	public MileTrack getJourney(@PathVariable Integer idGet) {
		return this.MTservice.getJourney(idGet);
	}
		
	
	
	//Listener for PUT request
	//Use ResponseEntity which uses @PathVariable to select the journey with correct idReplace
	//and @RequetsBody to create a new entry/record/object of MileTrack
	//send a text confirmation of update
	//return the new data registered against journey with idReplace 
	@PutMapping("replaceJourney/{idReplace}")
	public ResponseEntity<MileTrack> replaceJourney(@PathVariable Integer idReplace, @RequestBody MileTrack newMileTrack){
		System.out.println("Warning: Replacing jouney with id: " + idReplace + " with " + newMileTrack);
		MileTrack responsePut = this.MTservice.replaceJourney(idReplace, newMileTrack);
		return new ResponseEntity<MileTrack>(responsePut,HttpStatus.ACCEPTED);
	}
	
	
	//Listener for DELETE request
	//Create a ResponseEntity response type
	//Use @PathVariable to select journey with same idRemove to the one in the URL
	//send a text confirmation of deleting that journey
	//return relevant HTTP confirmation if deletion was complete	
	@DeleteMapping("/removeJourney/{idRemove}")
	public ResponseEntity<?> removeJourney(@PathVariable Integer idRemove){
		System.out.println("Warning: Removing journey with id: " + idRemove);
		boolean removed = this.MTservice.removeJourney(idRemove);
		if(removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
}
