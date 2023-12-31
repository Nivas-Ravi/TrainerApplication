package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.TrainerBO;

import com.example.demo.dto.TrainerDTO;
import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.entity.Description;
import com.example.demo.entity.State;
import com.example.demo.entity.Trainer;

@RestController
public class TrainerService {
     
	@Autowired
	TrainerBO trainerBO;
	

	
	@RequestMapping(value="/addTrainer",method=RequestMethod.POST)
	public TrainerDTO addtrainer(@RequestBody TrainerDTO trainerdto) {
		Trainer trainer=new Trainer();
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
		Trainer train=trainerBO.insert(trainer);
		trainerdto.setTrainerId(train.getTrainerId());
		return trainerdto;
		
	}
	
//	@RequestMapping(value="/fetchTrainerById",method=RequestMethod.GET)
//	public TrainerDTO fetchTrainer(@RequestBody int trainerId) {
//		Trainer trainer=trainerBO.findById(trainerId);
//		TrainerDTO trainerdto=new TrainerDTO();
//		trainer.setTrainerId(trainerdto.getTrainerId());
//		trainer.setTrainerName(trainerdto.getTrainerName());
//		trainer.setTrainerExperience(trainerdto.getTrainerExperience());
//		trainer.setDescription(trainerdto.getDescription());
//		trainer.setCity(trainerdto.getCity());
//		trainer.setState(trainerdto.getState());
//		trainer.setCountry(trainerdto.getCountry());
//		trainer.setTrainerNumber(trainerdto.getTrainerNumber());
//		
//		
//	}
	
	
}
