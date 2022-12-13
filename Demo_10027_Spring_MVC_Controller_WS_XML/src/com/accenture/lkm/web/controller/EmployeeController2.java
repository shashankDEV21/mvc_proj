package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.lkm.bussiness.bean.EmployeeBean;
import com.accenture.lkm.bussiness.bean.EmployeeListWrapper;
import com.accenture.lkm.service.EmployeeServiceImpl;

@RestController
public class EmployeeController2 {
	
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@RequestMapping(value="emp/controller2/json/getDetails",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EmployeeBean> getEmployeeDetails(){
		return employeeService.getAllEmployees();
	}
	@RequestMapping(value="emp/controller2/xml/getDetails",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_XML_VALUE)
	public EmployeeListWrapper getEmployeeDetails2(){
		
		List <EmployeeBean> listEmployee =employeeService.getAllEmployees();
		EmployeeListWrapper employeeListWrapper = new   EmployeeListWrapper();
		employeeListWrapper.setListEmp(listEmployee);
		return employeeListWrapper;
		
	}

}
