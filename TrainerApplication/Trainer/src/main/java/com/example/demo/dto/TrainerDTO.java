package com.example.demo.dto;

import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.entity.Description;
import com.example.demo.entity.State;



public class TrainerDTO {

	private int trainerId;

	private String trainerName;
	
	
	private int trainerExperience;
	

	private Description description;
	
	
	private City city;
	
	
	private State state;
	
	
	private Country country;
	
	

	private String trainerNumber;
	

	public int getTrainerId() {
		return trainerId;
	}


	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}


	public String getTrainerName() {
		return trainerName;
	}


	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}


	public int getTrainerExperience() {
		return trainerExperience;
	}


	public void setTrainerExperience(int trainerExperience) {
		this.trainerExperience = trainerExperience;
	}


	public Description getDescription() {
		return description;
	}


	public void setDescription(Description description) {
		this.description = description;
	}


	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}


	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public String getTrainerNumber() {
		return trainerNumber;
	}


	public void setTrainerNumber(String trainerNumber) {
		this.trainerNumber = trainerNumber;
	}


	@Override
	public String toString() {
		return "TrainerDTO [trainerId=" + trainerId + ", trainerName=" + trainerName + ", trainerExperience="
				+ trainerExperience + ", description=" + description + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", trainerNumber=" + trainerNumber + "]";
	}


	
	
}
