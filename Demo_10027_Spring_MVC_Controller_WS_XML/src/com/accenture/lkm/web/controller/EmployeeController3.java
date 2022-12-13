package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.lkm.bussiness.bean.EmployeeBean;
import com.accenture.lkm.bussiness.bean.EmployeeListWrapper;
import com.accenture.lkm.service.EmployeeServiceImpl;

@Controller
public class EmployeeController3 {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@RequestMapping(value="emp/controller3/json/getDetails",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeBean>> getEmployeeDetails(){
		return new ResponseEntity<List<EmployeeBean>>(employeeService.getAllEmployees(), HttpStatus.OK);	
	}
	@RequestMapping(value="emp/controller3/xml/getDetails",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<EmployeeListWrapper> getEmployeeDetails2(){		
		List <EmployeeBean> listEmployee =employeeService.getAllEmployees();
		EmployeeListWrapper employeeListWrapper = new   EmployeeListWrapper();
		employeeListWrapper.setListEmp(listEmployee);
		return new ResponseEntity<EmployeeListWrapper>(employeeListWrapper, HttpStatus.OK);	
	}
}
