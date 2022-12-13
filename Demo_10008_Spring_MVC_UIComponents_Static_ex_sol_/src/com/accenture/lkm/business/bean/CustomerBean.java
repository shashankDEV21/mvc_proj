package com.accenture.lkm.business.bean;

public class CustomerBean {
	private String customerName;
	private String password;
	private String gender;
	private String customerType="1";
	private String addtionalSteps;
	private String[] customerServices={"MV","EV"};
	private Boolean homeDelivery;
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
	
}
