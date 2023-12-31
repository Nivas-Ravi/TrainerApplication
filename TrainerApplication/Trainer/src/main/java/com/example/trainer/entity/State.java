package com.example.trainer.entity;


import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class State {
	
	@Id
    private  int stateId;
	
	private String stateName;
	

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	
	
}
