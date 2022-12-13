package com.accenture.lkm.business.bean;

import java.util.Date;

public class CustomerBean {
	
	//Email
	//max=10,min=2
	private String customerName;
	
	//Not to be Empty
	private String password;
	
	//Not to be Empty
	private String gender;
	
	//Not to be Empty
	private String customerType="1";
	
	//min=10
	private String addtionalSteps;
	
	//min=2
	private String[] customerServices={"MV","EV"};
	
	//should be true
	private Boolean homeDelivery;
	
	
	//Not to be Null
	//should be in range max=110,min=10
	private Integer age;
	
	//Not to be Empty
	//should be in range max=800000,min=1000
	private Double bill;
	
	//Not to be Null
	//should be future
	// display format pattern="dd-MMM-yyyy"
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
