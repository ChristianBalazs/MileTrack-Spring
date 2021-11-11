package com.miletrack.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miletrack.main.domain.MileTrack;


//Role: Interface to define methods for interacting with a database

//Changed to interface which extends JpaRepository

//Implement @Repository in front of this class so that this class can   
//be used as a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects


@Repository
public interface MileTrackRepo extends JpaRepository<MileTrack, Integer>{

}
