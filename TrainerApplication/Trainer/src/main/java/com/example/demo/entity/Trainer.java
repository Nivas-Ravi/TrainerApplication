package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="trainer")
public class Trainer {
	
	@Id
	private int trainerId;
	
	//@NotBlank
	private String trainerName;
	
	//@NotNull
	private int trainerExperience;
	
	@ManyToOne
	@JoinColumn(name="descriptionId",nullable=false,referencedColumnName="descriptionId")
	//@NotBlank
	private Description description;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cityId",nullable=false,referencedColumnName="cityId")
	//@NotBlank
	private City city;
	
	@ManyToOne
	@JoinColumn(name="stateId",nullable=false,referencedColumnName="stateId")
	//@NotNull
	private State state;
	
	@ManyToOne
	@JoinColumn(name="countryId",nullable=false,referencedColumnName="countryId")
	//@NotBlank
	private Country country;
	
	//@NotBlank
	private String trainerNumber;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "customer_trainer_relationship", joinColumns = {
	@JoinColumn(name = "trainer_id", nullable = false) }, inverseJoinColumns = {
	@JoinColumn(name = "customer_id", nullable = false) })
	private List<Customer> customers;

	public List<Customer> getCustomer() {
		return customers;
	}

	public void setCustomer(List<Customer> customers) {
		this.customers = customers;
	}

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
	
	public int getTrainerExperience() {
		return trainerExperience;
	}

	public void setTrainerExperience(int trainerExperience) {
		this.trainerExperience = trainerExperience;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", description=" + description.getDescriptionName()
				+ ", city=" + city.getCityName() + ", state=" + state.getStateName() + ", country=" + country.getCountryName() + ", trainerNumber=" + trainerNumber
				+ "]";
	}
      
}