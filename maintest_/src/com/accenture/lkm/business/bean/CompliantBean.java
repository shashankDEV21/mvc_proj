package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class CompliantBean {
Integer compliantId;
@NotEmpty(message="please enter customer name")
String customerName;
String description;
@Past
@DateTimeFormat(pattern="dd-MMM-yyyy")
@NotNull(message="please Enter Date Of Incidence")
Date dateOfIncidence;
@NotNull(message="please mention total amount of loss you have suffered through this incidence")
Double amount;
@NotNull(message="please enter customer type")
Integer compliantTypeId;
public Integer getCompliantId() {
	return compliantId;
}
public void setCompliantId(Integer compliantId) {
	this.compliantId = compliantId;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getDateOfIncidence() {
	return dateOfIncidence;
}
public void setDateOfIncidence(Date dateOfIncidence) {
	this.dateOfIncidence = dateOfIncidence;
}
public Double getAmount() {
	return amount;
}
public void setAmount(Double amount) {
	this.amount = amount;
}
public Integer getCompliantTypeId() {
	return compliantTypeId;
}
public void setCompliantTypeId(Integer compliantTypeId) {
	this.compliantTypeId = compliantTypeId;
}
}
