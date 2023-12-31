package com.example.trainer.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.trainer.TrainerApplication;
import com.example.trainer.bo.TrainerBO;
import com.example.trainer.dao.CityTrainerCustomized;
import com.example.trainer.dao.TrainerCustomerCustomized;
import com.example.trainer.dao.TrainerCustomized;
import com.example.trainer.dao.TrainerRepository;
import com.example.trainer.entity.Trainer;
import com.example.trainer.exception.NotFoundException;
import com.example.trainer.exception.TrainerDataException;

public class TrainerService {

	Logger log = Logger.getLogger(TrainerApplication.class);
	
	@Autowired
	TrainerBO trainerBO;
	
	@Autowired
	TrainerRepository trainerrepository;

	// Method to insert a Trainer after validation
	public boolean insert(Trainer trainer) throws TrainerDataException {
		
		try {
			boolean validate=trainerBO.insert(trainer);
			return validate;
		}catch(TrainerDataException e) {
			throw new TrainerDataException(e.getMessage());
		}
	
	}
	
	public boolean update(Trainer trainer) throws TrainerDataException {
		try {
			boolean validate=trainerBO.update(trainer);
			return validate;
		}catch(TrainerDataException e) {
			throw new TrainerDataException(e.getMessage());
		}
		
	
	}

	// Method to find a Trainer by ID
	public Trainer findById(int id) throws NotFoundException {
		log.info("fetch trainer details triggered...");
		try {
			Trainer trainer = trainerBO.findById(id);
			return trainer;
		} catch (NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		}
	}

	// Method to find all Trainers
	public List<Trainer> findAll() {
		List<Trainer> list = trainerBO.findAll();
		return list;
	}

	// Method to find Trainer(s) by ID
	public List<Trainer> findTrainerById(int id) throws NotFoundException {
		
		try {
			List<Trainer> trainer = trainerBO.findTrainerById(id);
			return trainer;
		}catch(NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		}
	}

	// Method to find Trainer(s) by name
	public List<Trainer> findByTrainerNames(String name) throws NotFoundException {
		try {
			List<Trainer> trainer = trainerBO.findByTrainerNames(name);
			return trainer;
		}catch(NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		}
	}

	// Method to find Trainer(s) by name with customized details
	public List<TrainerCustomized> findByTrainerNameCustomized(String name) throws NotFoundException {
		try {
			List<TrainerCustomized> trainerDetails = trainerBO.findByTrainerNameCustomized(name);
			return trainerDetails;
		}catch(NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		}
	}

	// Method to find Trainers along with Customer details
	public List<TrainerCustomerCustomized> findTrainerWithCustomer() {
		List<TrainerCustomerCustomized> trainerCustomer=trainerBO.findTrainerWithCustomer();
		return trainerCustomer;
	}

	// Method to find Trainers for each city
	public List<CityTrainerCustomized> findTrainerForEachCity() {
		List<CityTrainerCustomized> trainerCity=trainerBO.findTrainerForEachCity();
		return trainerCity;
	}
}
