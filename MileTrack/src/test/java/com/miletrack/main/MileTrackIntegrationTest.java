package com.miletrack.main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miletrack.main.domain.MileTrack;



//Use @SpringBootTest to Start up MileTrack application context to be used in a test
//Use @AutoConfigureMockMvc to encapsulates all web application beans and makes them available for testing.

@SpringBootTest 
@AutoConfigureMockMvc
public class MileTrackIntegrationTest {

	
	@Autowired 
	private MockMvc testMvc;
	
	//Use ObjectMapper to provide reading and writing JSON, 
	//either to and from basic POJOs (Plain Old Java Objects), or 
	//to and from a general-purpose JSON
	@Autowired
	private ObjectMapper mapperTest;
	
	
	@Test
	void createJourneyTest()throws Exception{
		
		//Test POST request for "/record"
		
		MileTrack requestBody = new MileTrack(1, "Dany", "saloon", "petrol", 140, "private"); 
		String requestBodyasJSON = this.mapperTest.writeValueAsString(requestBody);
		
		RequestBuilder requestB = post("/record").contentType(MediaType.APPLICATION_JSON).content(requestBodyasJSON);
	
		
		MileTrack responseBody = new MileTrack(1, "Dany", "saloon", "petrol", 140, "private"); 
		String responseBodyasJSON = this.mapperTest.writeValueAsString(responseBody);
		
		ResultMatcher statusCheck = status().isCreated();
		ResultMatcher bodyCheck = content().json(responseBodyasJSON);
		
		this.testMvc.perform(requestB).andExpect(statusCheck).andExpect(bodyCheck);		
		
		
		//Test PUT request for "replaceJourney/id
		
		MileTrack requestBody2 = new MileTrack(1, "Anne", "SUV", "petrol", 200, "private");
		String requestBodyasJSON2 = this.mapperTest.writeValueAsString(requestBody2);
		
		RequestBuilder requestB2 = put("/replaceJourney/1").contentType(MediaType.APPLICATION_JSON).content(requestBodyasJSON2);
	
		
		MileTrack responseBody2 = new MileTrack(1, "Anne", "SUV", "petrol", 200, "private");
		String responseBodyasJSON2 = this.mapperTest.writeValueAsString(responseBody2);
		
		ResultMatcher statusCheck2 = status().isAccepted();
		ResultMatcher bodyCheck2 = content().json(responseBodyasJSON2);
		
		this.testMvc.perform(requestB2).andExpect(statusCheck2).andExpect(bodyCheck2);	
		
		
		
		//Test GET request for "/hello"
				
		RequestBuilder requestB3 = get("/hello").contentType(MediaType.APPLICATION_JSON);
	
		
		String responseBody3 = "Welcome to MileTrack Application!"; 		
		
		ResultMatcher statusCheck3 = status().isOk();
		ResultMatcher bodyCheck3 = content().string(responseBody3);
		
		this.testMvc.perform(requestB3).andExpect(statusCheck3).andExpect(bodyCheck3);	
		
		
		
		//Test GET for "/getAllJourneys "
		RequestBuilder requestB4 = get("/getAllJourneys").contentType(MediaType.APPLICATION_JSON);
				
		MileTrack responseBody4 = new MileTrack(1, "Anne", "SUV", "petrol", 200, "private");
		
		String responseBodyasJSON4 = this.mapperTest.writeValueAsString(responseBody4);
		
		ResultMatcher statusCheck4 = status().isOk();
		ResultMatcher bodyCheck4 = content().json(responseBodyasJSON4);		
		
		this.testMvc.perform(requestB4).andExpect(statusCheck4);
		
		
				
		
		//Test DELETE for "/removeJourney/id"		
		
		RequestBuilder requestB5 = delete("/removeJourney/1").contentType(MediaType.APPLICATION_JSON);
								
		ResultMatcher statusCheck5 = status().isNoContent();
			
		this.testMvc.perform(requestB5).andExpect(statusCheck5);
		
		
		
	
	}
	
	
	
	
		

	
}
