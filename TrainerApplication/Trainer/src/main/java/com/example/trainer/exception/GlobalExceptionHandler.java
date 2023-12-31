package com.example.trainer.exception;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.trainer.TrainerApplication;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	Logger log = Logger.getLogger(TrainerApplication.class);
	
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleInvalidInputException(MethodArgumentTypeMismatchException ex) {
		if(log.isInfoEnabled()) {
			  log.error(ex);
		    }		String errors = "Invalid input format.Please provide a valid Integer";
        return new ResponseEntity<>(errors, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

	
//	@Order(Ordered.HIGHEST_PRECEDENCE)
//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<String> handleNumberFormatException(NumberFormatException ex) {
//		log.error("Invalid input format. Please provide a valid Integer", ex);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body("Invalid input format. Please provide a valid integer.");
//    }
	

	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleValidationErrors(Exception ex) {
		if(log.isInfoEnabled()) {
		  log.error(ex);
	    }
        String errors = "Error in code.Please contact Admin";
       return new ResponseEntity<>(errors,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
	
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
//        // Customize the error message for the specific JSON parse issue
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body("Invalid JSON format. Please check your request payload.");
//    }
	
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
    	if(log.isInfoEnabled()) {
  		  log.error(ex);
  	    }
        return ResponseEntity.badRequest()
                .body("Invalid input format. Please provide valid integer for :- \n"
                		+ "1)trainerId \n"
                		+ "2)trainerExperience \n"
                		+ "3)DescriptionId \n"
                		+ "4)cityId \n"
                		+ "5)stateId \n"
                		+ "6)countryId. \n");
    }
}