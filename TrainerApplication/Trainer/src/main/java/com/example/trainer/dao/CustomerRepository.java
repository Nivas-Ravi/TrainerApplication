package com.example.trainer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainer.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
     //NamedQuery
	List<Customer> findAllNameDescending();
}
