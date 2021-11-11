package com.miletrack.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.miletrack.main.service.MileTrackService;


//Role: main class of the application, enables SpringBoot 

@SpringBootApplication
public class MileTrackApplication {

	public static void main(String[] args) throws Exception {
		
		//Imported ApplicationContext
		//The ApplicationContext is the central interface within a Spring application 
		//Used for providing configuration information to the application. 
		//Implements the BeanFactory interface
		
		ApplicationContext mtAC = SpringApplication.run(MileTrackApplication.class, args);
	
		MileTrackService mtService = mtAC.getBean(MileTrackService.class);
		
		System.out.println(mtService);
		
	
	
	}

}
