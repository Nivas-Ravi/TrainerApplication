package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer>{
    
	@Query(value="select t from Trainer t where t.trainerId> :id")
	List<Trainer> findTrainerById(@Param ("id") int trainerId );
	
	@Query(value="select t from Trainer t where t.trainerName LIKE %:name%")
	List<Trainer> findByName(@Param ("name") String trainerName);
	
	//To fetch only few columns from trainer
	@Query("select t.city as city,t.country as country from Trainer t where t.trainerName=:name")
	List<TrainerCustomized> findByTrainerNameCustomized(@Param ("name") String trainerName); 
	
	@Query("SELECT t FROM Trainer t JOIN  t.customers c")
	List<TrainerCustomerCustomized> findTrainerWithCustomer();
	
	@Query("select t.city,Max(t.trainerExperience) as MaximumExperience from Trainer t group by t.city")
	List<CityTrainerCustomized> findTrainerForEachCity();
}
