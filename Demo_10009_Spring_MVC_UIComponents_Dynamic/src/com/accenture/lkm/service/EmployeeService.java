package com.accenture.lkm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.dao.EmployeeDAO;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO dao;
	
	
	public Map<String, String> getCountries() {
		return dao.getCountries();
	}
	
	
	public List<String> getCountriesSameValueAndLabel() {
		return dao.getCountriesSameValueAndLabel();
	}

	
	public Map<String, String> getCommunities() {
		return dao.getCommunities();
	}
	
	public Map<String, String> getGender() {
		return dao.getGender();
	}
}
