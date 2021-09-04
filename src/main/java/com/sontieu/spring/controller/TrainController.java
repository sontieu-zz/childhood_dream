package com.sontieu.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sontieu.spring.model.Train;
import com.sontieu.spring.repository.TrainRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TrainController {

	@Autowired
	TrainRepository trainRepository;
	
	@GetMapping("/trains")
	public ResponseEntity<List<Train>> getAllTrains() {
		try {
			List<Train> trains = trainRepository.findAll();

			if (trains.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(trains, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/trains/{id}")
	public ResponseEntity<Train> getTrainById(@PathVariable("id") long id) {
		Optional<Train> trainData = trainRepository.findById(id);
		
		if (trainData.isPresent()) {
			return new ResponseEntity<>(trainData.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Train>(HttpStatus.NOT_FOUND);
	}
}
