package com.example.demo.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
@NamedQuery(name="Customer.findAllNameDescending",query=" select c from Customer c order by c.customerName DESC")
public class Customer {

	@Id
	private int customerId;

//	@NotBlank
	private String customerName;

	
	private Date customerDob;

	//@NotNull
	private BigDecimal customerWeight;

	//@NotNull
	private BigDecimal customerHeight;

	//@NotNull
	private BigDecimal customerBmi;

	//@NotBlank
	private String customerStreet;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cityId", nullable = false, referencedColumnName = "cityId")
	private City cityId;

	@ManyToOne
	@JoinColumn(name = "stateId", nullable = false, referencedColumnName = "stateId")
	//@NotBlank
	private State stateId;

	@ManyToOne
	@JoinColumn(name = "countryId", nullable = false, referencedColumnName = "countryId")
	//@NotNull
	private Country countryId;

	//@NotBlank
	private String customerNumber;

	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL, mappedBy = "customers")
	private List<Trainer> trainers;

	public List<Trainer> getTrainer() {
		return trainers;
	}

	public void setTrainer(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	public BigDecimal getCustomerWeight() {
		return customerWeight;
	}

	public void setCustomerWeight(BigDecimal customerWeight) {
		this.customerWeight = customerWeight;
	}

	public BigDecimal getCustomerHeight() {
		return customerHeight;
	}

	public void setCustomerHeight(BigDecimal customerHeight) {
		this.customerHeight = customerHeight;
	}

	public BigDecimal getCustomerBmi() {
		return customerBmi;
	}

	public void setCustomerBmi(BigDecimal customerBmi) {
		this.customerBmi = customerBmi;
	}

	public String getCustomerStreet() {
		return customerStreet;
	}

	public void setCustomerStreet(String customerStreet) {
		this.customerStreet = customerStreet;
	}

	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public State getStateId() {
		return stateId;
	}

	public void setStateId(State stateId) {
		this.stateId = stateId;
	}

	public Country getCountryId() {
		return countryId;
	}

	public void setCountryId(Country countryId) {
		this.countryId = countryId;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerDob=" + customerDob
				+ ", customerWeight=" + customerWeight + ", customerHeight=" + customerHeight + ", customerBmi="
				+ customerBmi + ", customerStreet=" + customerStreet + ", cityId=" + cityId.getCityName() + ", stateId="
				+ stateId.getStateName() + ", countryId=" + countryId.getCountryName() + ", customerNumber="
				+ customerNumber + "]";
	}

}
