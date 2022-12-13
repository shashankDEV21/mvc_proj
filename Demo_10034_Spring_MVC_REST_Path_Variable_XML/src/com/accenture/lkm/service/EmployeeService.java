package com.accenture.lkm.service;

import java.util.Collection;
import java.util.List;

import com.accenture.lkm.bussiness.bean.EmployeeBean;

public interface EmployeeService {

	Collection<EmployeeBean> getAllEmployee();

	EmployeeBean getEmployeeDetailsById(int id);

	Integer addEmployee(EmployeeBean employee);

	EmployeeBean updateEmployee(EmployeeBean employee);

	void removeEmployee(int id);
	
	List<EmployeeBean> getEmployeeDetailsWithinSalaryRange(double min, double max);

}