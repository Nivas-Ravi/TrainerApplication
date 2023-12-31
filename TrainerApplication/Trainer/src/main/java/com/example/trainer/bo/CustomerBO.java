//package com.example.trainer.bo;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.example.trainer.dao.CustomerRepository;
//import com.example.trainer.entity.Customer;
//
//@Component
//public class CustomerBO {
//	@Autowired
//	CustomerRepository customerrepository;
//
//	public void insert(Customer customer) {
//		customerrepository.save(customer);
//	}
//
//	public Customer findById(int id) {
//		Optional<Customer> customer = customerrepository.findById(id);
//		return customer.get();
//	}
//
////	public void findAll() {
////		List<Customer> list = customerrepository.findAll();
////
////		for (Customer aList : list) {
////			System.out.println(aList);
////		}
////	}
//
//	public List<Customer> findAllNameDescending() {
//		return customerrepository.findAllNameDescending();
//	}
//}
