package com.example.trainer.entity;



import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Country {
	
	@Id
    private  int countryId;
	
	//@NotBlank
	private String countryName;
	

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + "]";
	}
	
	
}
