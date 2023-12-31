package com.example.trainer.bo;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.trainer.dao.CityTrainerCustomized;
import com.example.trainer.dao.TrainerCustomerCustomized;
import com.example.trainer.dao.TrainerCustomized;
import com.example.trainer.dao.TrainerRepository;
import com.example.trainer.entity.Trainer;
import com.example.trainer.exception.NotFoundException;
import com.example.trainer.exception.TrainerDataException;

@Component
public class TrainerBO {

	@Autowired
	TrainerRepository trainerrepository;

	// Method to insert a Trainer after validation
	public boolean insert(Trainer trainer) throws TrainerDataException {
		boolean validate = false;
		if(trainerValidation(trainer)) {
			validate=true;
			trainerrepository.save(trainer);
		}
		return validate;
	
	}
	
	public boolean update(Trainer trainer) throws TrainerDataException {
		
		boolean validate = false;
		Optional<Trainer> existingTrainer = trainerrepository.findById(trainer.getTrainerId());
	    
	    if(existingTrainer.isEmpty()) {
	        throw new TrainerDataException("Given ID is not exist in the table");
	    } else {
	        // Perform validations and update only if the Trainer exists
	        if (trainerValidation(trainer)) {
	            trainerrepository.save(trainer);
	            return true;
	        }
	    }
		return validate;
	
	}

	// Method to find a Trainer by ID
	public Trainer findById(int id) throws NotFoundException {
		Optional<Trainer> trainer = trainerrepository.findById(id);
		if (trainer.isPresent()) {
			return trainer.get();
		} else {
			throw new NotFoundException("Trainer Id does not exist in the database");
		}
	}

	// Method to find all Trainers
	public List<Trainer> findAll() {
		List<Trainer> list = trainerrepository.findAll();
		return list;
	}

	// Method to find Trainer(s) by ID
	public List<Trainer> findTrainerById(int id) throws NotFoundException {
		List<Trainer> trainer = trainerrepository.findTrainerById(id);
		if (!trainer.isEmpty()) {
			return trainer;
		} else {
			throw new NotFoundException("Trainers Above this ID does not exist in the database");
		}
	}

	// Method to find Trainer(s) by name
	public List<Trainer> findByTrainerNames(String name) throws NotFoundException {
		List<Trainer> trainer = trainerrepository.findByName(name);
		if (!trainer.isEmpty()) {
			return trainer;
		} else {
			throw new NotFoundException("Trainer Name does not exist in the database");
		}
	}

	// Method to find Trainer(s) by name with customized details
	public List<TrainerCustomized> findByTrainerNameCustomized(String name) throws NotFoundException {
		List<TrainerCustomized> trainerDetails = trainerrepository.findByTrainerNameCustomized(name);
		if (!trainerDetails.isEmpty()) {
			return trainerDetails;
		} else {
			throw new NotFoundException("Trainer Name does not exist in the database");
		}
	}

	// Method to find Trainers along with Customer details
	public List<TrainerCustomerCustomized> findTrainerWithCustomer() {
		return trainerrepository.findTrainerWithCustomer();
	}

	// Method to find Trainers for each city
	public List<CityTrainerCustomized> findTrainerForEachCity() {
		return trainerrepository.findTrainerForEachCity();
	}

	// Method to validate Trainer data
	public boolean trainerValidation(Trainer vo) throws TrainerDataException {
		boolean flag = true;
		if (vo.getTrainerId() < 0) {
			flag = false;
			throw new TrainerDataException("Invalid trainerId. Please enter a positive integer.");
		}
		if (vo.getTrainerName().isEmpty()) {
			flag = false;
			throw new TrainerDataException("Invalid trainerName. Please enter a non-empty name.");
		}

		Pattern namePattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher nameMatcher = namePattern.matcher(vo.getTrainerName());
		if (!nameMatcher.matches()) {
			flag = false;
			throw new TrainerDataException("Invalid trainerName. Please enter alphabetic characters only.");
		}

		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(vo.getTrainerNumber());
		if (!matcher.matches()) {
			flag = false;
			throw new TrainerDataException("Invalid trainerNumber.Please enter a number with only numerics");
		}

		if (vo.getTrainerNumber().length() >10) {
			flag = false;
			throw new TrainerDataException("Invalid trainerNumber.Trainer Number Should be of size 10");
		}

		return flag;
	}
}
