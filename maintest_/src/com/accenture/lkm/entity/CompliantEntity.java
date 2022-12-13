package com.accenture.lkm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="compliant")
public class CompliantEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer compliantId;
	String customerName;
	String description;
	@Temporal(TemporalType.DATE)
	Date dateOfIncidence;
	Double amount;
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
}
