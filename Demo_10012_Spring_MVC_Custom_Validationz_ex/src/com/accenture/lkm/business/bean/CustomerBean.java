package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class CustomerBean {
	//Add the Custom annotation 
	@Size(max=10,min=2)
	private String customerName;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String gender;
	
	@NotEmpty
	private String customerType="1";
	
	@Size(min=10)
	private String addtionalSteps;
	
	@Size(min=2)
	private String[] customerServices={"MV","EV"};
	
	@AssertTrue
	private Boolean homeDelivery;
	
	
	@NotNull
	@Range(max=110,min=10)
	private Integer age;
	
	@NotNull
	@Range(max=800000,min=1000)
	private Double bill;
	
	@NotNull
	@Future
	@DateTimeFormat(pattern="dd-MMM-yyyy") //default format is MM/dd/yy
	private Date joiningDate;
		
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getAddtionalSteps() {
		return addtionalSteps;
	}
	public void setAddtionalSteps(String addtionalSteps) {
		this.addtionalSteps = addtionalSteps;
	}
	public String[] getCustomerServices() {
		return customerServices;
	}
	public void setCustomerServices(String[] customerServices) {
		this.customerServices = customerServices;
	}
	public Boolean getHomeDelivery() {
		return homeDelivery;
	}
	public void setHomeDelivery(Boolean homeDelivery) {
		this.homeDelivery = homeDelivery;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
}
