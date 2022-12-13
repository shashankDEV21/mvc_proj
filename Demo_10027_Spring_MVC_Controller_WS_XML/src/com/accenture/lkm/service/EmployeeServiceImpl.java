package com.accenture.lkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.bussiness.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDAOImpl;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;
	
	public List<EmployeeBean> getAllEmployees() {

		return employeeDAOImpl.getAllEmployees();
	}
}
