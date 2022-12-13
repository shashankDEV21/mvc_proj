package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.bussiness.bean.EmployeeBean;

@Repository
public class EmployeeDAOImpl {

	static List<EmployeeBean> listEmployee = new ArrayList<EmployeeBean>();
	static {
		listEmployee.add(new EmployeeBean("Jack", 10001, 12345.6, 1001));
		listEmployee.add(new EmployeeBean("Justin", 10002, 12345.6, 1002));
		listEmployee.add(new EmployeeBean("Eric", 10002, 12345.6, 1003));
	}

	public List<EmployeeBean> getAllEmployees() {

		return listEmployee;
	}
}
