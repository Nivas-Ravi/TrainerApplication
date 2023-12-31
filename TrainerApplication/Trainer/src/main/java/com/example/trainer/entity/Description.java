package com.example.trainer.entity;



import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Description {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private  int descriptionId;
	
	
	private String descriptionName;
	
	public int getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getDescriptionName() {
		return descriptionName;
	}

	public void setDescriptionName(String descriptionName) {
		this.descriptionName = descriptionName;
	}


}
