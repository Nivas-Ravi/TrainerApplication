package com.example.demo.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CityTrainerCustomized;
import com.example.demo.dao.TrainerCustomerCustomized;
import com.example.demo.dao.TrainerCustomized;
import com.example.demo.dao.TrainerRepository;
import com.example.demo.entity.Trainer;

@Component
public class TrainerBO {
	
	@Autowired
	TrainerRepository trainerrepository;
	
	public Trainer insert(Trainer trainer) {
		return trainerrepository.save(trainer);
	}
	public Trainer  findById(int id) {
		Optional<Trainer> trainer=trainerrepository.findById(id);
		return trainer.get();
	}
	
	public List<Trainer> findAll(){
		 List<Trainer> list = trainerrepository.findAll();
		 return list;	
	}
	
	public List<Trainer> findTrainerById(int id){
		return trainerrepository.findTrainerById(id);
	}
	
	public List<Trainer> findByTrainerNames(String name){
		return trainerrepository.findByName(name);
	}
	public List<TrainerCustomized> findByTrainerNameCustomized(String name){
		return trainerrepository.findByTrainerNameCustomized(name);
	}
	
	public List<TrainerCustomerCustomized> findTrainerWithCustomer(){
		return trainerrepository.findTrainerWithCustomer();
	}
	
	public List<CityTrainerCustomized> findTrainerForEachCity(){
		return trainerrepository.findTrainerForEachCity();
	}
}
