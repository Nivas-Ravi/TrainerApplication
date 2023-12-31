package com.example.trainer.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainer.TrainerApplication;
//import com.example.trainer.bo.CustomerBO;
import com.example.trainer.bo.TrainerBO;
import com.example.trainer.dao.CityTrainerCustomized;
import com.example.trainer.dao.TrainerCustomerCustomized;
import com.example.trainer.dao.TrainerCustomized;
import com.example.trainer.dto.TrainerDTO;
import com.example.trainer.entity.City;
import com.example.trainer.entity.Country;
import com.example.trainer.entity.Customer;
import com.example.trainer.entity.Description;
import com.example.trainer.entity.State;
import com.example.trainer.entity.Trainer;
import com.example.trainer.exception.NotFoundException;
import com.example.trainer.exception.TrainerDataException;

@RequestMapping("/api/user")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TrainerController {

	Logger log = Logger.getLogger(TrainerApplication.class);

	@Autowired
	TrainerBO trainerBO;

//	@Autowired
//	CustomerBO customerBO;

	
	// API to add a new Trainer
	@RequestMapping(value = "/addTrainer", method = RequestMethod.POST)
	public ResponseEntity<?> addtrainer(@RequestBody TrainerDTO trainerdto) {
		log.info("Insert trainer details triggered...");
		try {
			System.out.println("IM IN");
			Trainer trainer = new Trainer();
			Description description = new Description();
			City city = new City();
			State state = new State();
			Country country = new Country();

			trainer.setTrainerId(trainerdto.getTrainerId());
			trainer.setTrainerName(trainerdto.getTrainerName());
			trainer.setTrainerExperience(trainerdto.getTrainerExperience());

			description.setDescriptionId(trainerdto.getDescription().getDescriptionId());
			trainer.setDescription(description);
			city.setCityId(trainerdto.getCity().getCityId());
			trainer.setCity(city);
			state.setStateId(trainerdto.getState().getStateId());
			trainer.setState(state);
			country.setCountryId(trainerdto.getCountry().getCountryId());
			trainer.setCountry(country);

			trainer.setTrainerNumber(trainerdto.getTrainerNumber());
			Boolean train = trainerBO.insert(trainer);

			if (train == true) {
				String successMessage = "Trainer Inserted Successfully";
				if (log.isInfoEnabled()) {
					log.info(successMessage + trainer);
				}
				return ResponseEntity.status(HttpStatus.OK).body(successMessage);
			} else {
				String failureMessage = "Please check the code.";
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMessage);
			}
		} catch (TrainerDataException e) {
			if (log.isInfoEnabled()) {
				log.error(e);
			}
			String failureMessage = e.getMessage();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMessage);

		} catch (Exception e) {
			if (log.isInfoEnabled()) {
				log.error(e);
			}
			String failureMessage = "Unexpected error occurred: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(failureMessage);
		}

	}
	
	@RequestMapping(value = "/updateTrainer", method = RequestMethod.POST)
	public ResponseEntity<?> updateTrainer(@RequestBody TrainerDTO trainerDTO) {
	    log.info("Update trainer details triggered..");
	    try {
	        Trainer trainer = new Trainer();
	        Description description = new Description();
	        City city = new City();
	        State state = new State();
	        Country country = new Country();
            trainer.setTrainerId(trainerDTO.getTrainerId());
	        trainer.setTrainerName(trainerDTO.getTrainerName());
	        trainer.setTrainerExperience(trainerDTO.getTrainerExperience());
	        description.setDescriptionId(trainerDTO.getDescription().getDescriptionId());
	        trainer.setDescription(description);
	        city.setCityId(trainerDTO.getCity().getCityId());
	        trainer.setCity(city);
	        state.setStateId(trainerDTO.getState().getStateId());
	        trainer.setState(state);
	        country.setCountryId(trainerDTO.getCountry().getCountryId());
	        trainer.setCountry(country);
	        trainer.setTrainerNumber(trainerDTO.getTrainerNumber());
	        
	        Boolean isUpdated = trainerBO.update(trainer);

	        if (isUpdated) {
	            String successMessage = "Trainer updated successfully";
	            log.info(successMessage);
	            return ResponseEntity.status(HttpStatus.OK).body(successMessage);
	        } else {
	            String failureMessage = "Failed to update Trainer with ID ";
	            log.warn(failureMessage);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMessage);
	        }
	    } catch (TrainerDataException e) {
	        log.error(e);
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	    } catch (Exception e) {
	        log.error("Unexpected error occurred: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
	    }
	}

	// API to fetch a Trainer by ID
	@RequestMapping(value = "/fetchTrainerById", method = RequestMethod.GET)
	public ResponseEntity<?> fetchTrainer(@RequestParam int trainerId) {
		log.info("fetch trainer details triggered...");
		try {
			Trainer trainer = trainerBO.findById(trainerId);
			log.info(trainer);
			return ResponseEntity.ok(trainer);
		} catch (NotFoundException e) {
			if (log.isInfoEnabled()) {
				log.error(e);
			}
			String failureMessage = e.getMessage();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMessage);
		}

	}

	// API to fetch all Trainers
	@GetMapping("/fetchAllTrainers")
	public List<Trainer> fetchAllTrainers() {
		log.info("FetchAll trainer details triggered...");
		List<Trainer> trainerEntity = trainerBO.findAll();
		return trainerEntity;
	}

	// API to fetch Trainers greater than a given ID
	@GetMapping("/trainersGreaterThanId")
	public ResponseEntity<?> fetchTrainerGreaterThanId(@RequestParam int trainerId) {
		log.info("fetchTrainerGreaterThanId trainer details triggered...");
		List<Trainer> trainerDetails;
		try {
			trainerDetails = trainerBO.findTrainerById(trainerId);
			return ResponseEntity.ok(trainerDetails);
		} catch (NotFoundException e) {
			if (log.isInfoEnabled()) {
				log.error(e);
			}
			String failureMessage = e.getMessage();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMessage);
		}
	}

	// API to fetch Trainer(s) by name
	@GetMapping("/fetchTrainerByName")
	public ResponseEntity<?> fetchTrainerByName(@RequestParam String trainerName) {
		log.info(" Fetch trainer Details By Name triggered...");
		List<Trainer> trainerDetails;
		try {
			trainerDetails = trainerBO.findByTrainerNames(trainerName);
			return ResponseEntity.ok(trainerDetails);
		} catch (NotFoundException e) {
			if (log.isInfoEnabled()) {
				log.error(e);
			}
			String failureMessage = e.getMessage();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMessage);
		}

	}

	// API to fetch Customer names in descending order
//	@GetMapping("/fetchCustomerNameInDescending")
//	public List<Customer> fetchCustomerNameInDescending() {
//		log.info(" Fetch Customer Name in Descending triggered...");
//		return customerBO.findAllNameDescending();
//	}

	// API to find Trainer details by name with customized details
	@GetMapping("/findByTrainerNameCustomized")
	public ResponseEntity<?> findByTrainerNameCustomized(@RequestParam String trainerName) {
		log.info(" Fetch Trainer Details By Name triggered...");
		try {
			List<TrainerCustomized> trainerDetails = trainerBO.findByTrainerNameCustomized(trainerName);
			return ResponseEntity.ok(trainerDetails);
		} catch (NotFoundException e) {
			if (log.isInfoEnabled()) {
				log.error(e);
			}
			String failureMessage = e.getMessage();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(failureMessage);
		}
	}

	// API to find Trainers along with Customer details
	@GetMapping("/findTrainerWithCustomer")
	public List<TrainerCustomerCustomized> findTrainerWithCustomer() {
		log.info(" Fetch Trainer with Customer  triggered...");
		return trainerBO.findTrainerWithCustomer();
	}

	// API to find maximum Trainer experience for each City
	@GetMapping("/findMaximumTrainerExperienceIneachCity")
	public List<CityTrainerCustomized> findTrainerForEachCity() {
		log.info("find Maximum Trainer Experience In each City triggered...");
		return trainerBO.findTrainerForEachCity();
	}

}
