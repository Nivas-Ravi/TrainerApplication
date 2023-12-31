package com.example.trainer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.trainer.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer>{
    
	@Query(value="select t from Trainer t where t.trainerId> :id")
	List<Trainer> findTrainerById(@Param ("id") int trainerId );
	
	@Query(value="select t from Trainer t where t.trainerName LIKE %:name%")
	List<Trainer> findByName(@Param ("name") String trainerName);
	
	//To fetch only few columns from trainer
	@Query("select t.city as city,t.country as country from Trainer t where t.trainerName=:name")
	List<TrainerCustomized> findByTrainerNameCustomized(@Param ("name") String trainerName); 
	
	@Query("SELECT t.trainerName AS trainerName, c.customerName AS customerName FROM Trainer t JOIN t.customers c")
	List<TrainerCustomerCustomized> findTrainerWithCustomer();
	
	@Query("SELECT c as city, MAX(t.trainerExperience) AS maxTrainerExperience FROM City c left JOIN Trainer t ON c.cityId = t.city.cityId GROUP BY c")
	List<CityTrainerCustomized> findTrainerForEachCity();


	
}
