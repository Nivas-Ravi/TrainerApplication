package com.example.trainer;

//import java.math.BigDecimal;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@SpringBootApplication
public class TrainerApplication {
	static Logger log = Logger.getLogger(TrainerApplication.class);
	public static void main(String[] args) {
	   log.info("Application Started...");
		SpringApplication.run(TrainerApplication.class, args);
		 
	}

}
