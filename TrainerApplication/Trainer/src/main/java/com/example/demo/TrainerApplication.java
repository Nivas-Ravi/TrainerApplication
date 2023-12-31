package com.example.demo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.bo.CustomerBO;
import com.example.demo.bo.TrainerBO;
import com.example.demo.dao.CityTrainerCustomized;
import com.example.demo.entity.City;
import com.example.demo.entity.Country;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Description;
import com.example.demo.entity.State;
import com.example.demo.entity.Trainer;

@SpringBootApplication
public class TrainerApplication {
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TrainerApplication.class, args);
		CustomerBO customerBO = ctx.getBean(CustomerBO.class);
		TrainerBO trainerBO = ctx.getBean(TrainerBO.class);
		
//		Trainer trainer = new Trainer();
//		Description description = new Description();
//		City city = new City();
//		State state = new State();
//		Country country = new Country();
//		trainer.setTrainerId(316);
//		trainer.setTrainerName("Karthi");
//		description.setDescriptionId(1);
//		trainer.setDescription(description);
//		city.setCityId(1);
//		trainer.setCity(city);
//		state.setStateId(2);
//		trainer.setState(state);
//		country.setCountryId(2);
//		trainer.setCountry(country);
//		trainer.setTrainerNumber("7895678945");
//
//		 trainerBO.insert(trainer);

		//To fetch trainer by ID
//	     System.out.println(trainerBO.findById(312));
		
		//To fetch all the TrainerDetails
//        List<Trainer> list = trainerBO.findAll();
//		 for(Trainer aList : list) {
//			 System.out.println(aList);
//		 }

//		Trainer trainer = new Trainer();
//		Description description = new Description();
//		City city1 = new City();
//		State state1 = new State();
//		Country country1 = new Country();
//		trainer.setTrainerId(323);
//		trainer.setTrainerName("simbu");
//		trainer.setTrainerExperience(5);
//		description.setDescriptionId(4);
//		trainer.setDescription(description);
//		city1.setCityId(3);
//		trainer.setCity(city1);
//		state1.setStateId(2);
//		trainer.setState(state1);
//		country1.setCountryId(2);
//		trainer.setCountry(country1);
//		trainer.setTrainerNumber("78956745656");
//
//		
//	
//	    Customer c2=new Customer();
//		City city2 = new City();
//		State state2 = new State();
//		Country country2 = new Country();
//	    c2.setCustomerId(110);
//	    c2.setCustomerName("Anu");
//	    c2.setCustomerDob(Date.valueOf("1997-03-19"));
//	    c2.setCustomerWeight(new BigDecimal(54.76));
//	    c2.setCustomerHeight(new BigDecimal(154.26));
//	    c2.setCustomerBmi(new BigDecimal(24.76));
//	    c2.setCustomerStreet("345,colony");
//	    city2.setCityId(2);
//	    c2.setCityId(city2);
//	    country2.setCountryId(2);
//	    c2.setCountryId(country2);
//	    state2.setStateId(3);
//	    c2.setStateId(state2);
//	    c2.setCustomerNumber("9873457895");
//		
//		
//	    Customer c1=new Customer();
//		City city = new City();
//		State state = new State();
//		Country country = new Country();
//	    c1.setCustomerId(111);
//	    c1.setCustomerName("Amala");
//	    c1.setCustomerDob(Date.valueOf("2000-03-19"));
//	    c1.setCustomerWeight(new BigDecimal(54.76));
//	    c1.setCustomerHeight(new BigDecimal(154.26));
//	    c1.setCustomerBmi(new BigDecimal(24.76));
//	    c1.setCustomerStreet("345,colony");
//	    city.setCityId(2);
//	    c1.setCityId(city);
//	    country.setCountryId(2);
//	    c1.setCountryId(country);
//	    state.setStateId(3);
//	    c1.setStateId(state);
//	    c1.setCustomerNumber("9876567895");
//	
//        List<Customer> customerList = new ArrayList<>();
//        customerList.add(c1);
//        customerList.add(c2);
//        trainer.setCustomer(customerList);
//        trainerBO.insert(trainer);

		// To find the customers for one trainer
//		Trainer trainers=trainerBO.findById(304);
//		List<Customer> traine=trainers.getCustomer();
//		System.out.println(trainers);
//		
//		for(Customer customerDetails:traine) {
//			System.out.println(customerDetails.getCustomerName());
//		}

		// To find the trainers for one customer
//		Customer customers = customerBO.findById(105);
//		List<Trainer> customer = customers.getTrainer();
//		System.out.println(customers);
//		for (Trainer trainerDetails : customer) {
//			System.out.println(trainerDetails.getTrainerName());
//		}
		 
		//Find BY ID using Query
//		 List<Trainer> trainers=trainerBO.findTrainerById(310);
//			for (Trainer trainerDetails : trainers) {
//			System.out.println(trainerDetails);
//		}
		
		//Find By Name using Query
//			 List<TrainerCustomized> trainer=trainerBO.findByTrainerNameCustomized("Johnson");
//				for (TrainerCustomized trainerDetails : trainer) {
//				System.out.println(trainerDetails.getCity().getCityName());
//				System.out.println(trainerDetails.getCountry().getCountryName());
//			}	
		//Find the Names in Descending Order using NamedQuery
//				 List<Customer> customer=customerBO.findAllNameDescending();
//					for (Customer customerDetails : customer) {
//					System.out.println(customerDetails.getCustomerName());
//				}
					
		//INNER JOIN
//		List<TrainerCustomerCustomized> trainerList=trainerBO.findTrainerWithCustomer(); 		
//		for (TrainerCustomerCustomized trainer : trainerList) {
//			System.out.println(trainer);
//		}
		
        //Aggregate function
//		 List<CityTrainerCustomized> trainers=trainerBO.findTrainerForEachCity();
//			for (CityTrainerCustomized trainerDetails : trainers) {
//			System.out.println(trainerDetails.getCity().getCityName()+" "+":"+" "+trainerDetails.getTrainerExperience());
//			
//		}
		 
	}

}
