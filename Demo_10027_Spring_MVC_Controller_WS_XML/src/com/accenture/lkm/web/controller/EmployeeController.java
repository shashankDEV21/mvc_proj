package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.lkm.bussiness.bean.EmployeeBean;
import com.accenture.lkm.bussiness.bean.EmployeeListWrapper;
import com.accenture.lkm.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@RequestMapping(value="emp/controller/json/getDetails",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<EmployeeBean> getEmployeeDetails(){
		return employeeService.getAllEmployees();
	}
	@RequestMapping(value="emp/controller/xml/getDetails",
			method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public EmployeeListWrapper getEmployeeDetails2(){
		
		List <EmployeeBean> listEmployee =employeeService.getAllEmployees();
		EmployeeListWrapper employeeListWrapper = new   EmployeeListWrapper();
		employeeListWrapper.setListEmp(listEmployee);
		return employeeListWrapper;
		
	}
	
}
