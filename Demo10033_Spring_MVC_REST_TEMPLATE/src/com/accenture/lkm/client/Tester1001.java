package com.accenture.lkm.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tester1001 {
	public static final String REST_SERVICE_URI = "http://localhost:8080/Demo_10031_Spring_MVC_REST_CRUD_JPA_Data_XML/emp/controller/";
	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllEmployees() {
		System.out.println("Testing listAllUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		//Hitting the Server URL and getting the response
		List<LinkedHashMap<String, Object>> listOfMap = restTemplate.getForObject(REST_SERVICE_URI + "getDetails", List.class); 
													
		//mapper to covert Object to a specific type  
		ObjectMapper mapper =  new ObjectMapper();
		List<EmployeeBean> list  = new ArrayList<EmployeeBean>();
		
		if (listOfMap != null) {
			for (LinkedHashMap<String, Object> map : listOfMap) {
				//Map object should be converted to Employee type 
				EmployeeBean emp=mapper.convertValue(map, EmployeeBean.class);
				list.add(emp);
			}
			System.out.println("Employee Details are: "+list);
		} else {
			System.out.println("No user exist----------");
		}
	}

	// GET 
	private static void getEmployee() {
		System.out.println("Testing getEmployee----------");
		RestTemplate restTemplate = new RestTemplate();
		//Placing Request and getting response
		EmployeeBean emp = restTemplate.getForObject(REST_SERVICE_URI + "getDetailsById/1003",EmployeeBean.class);
		System.out.println(emp);
	}

	 //POST 
	private static void createEmployee() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		EmployeeBean emp = new EmployeeBean(0,"TestMSD","Manager",new Date(),1000.0);
		//Placing Request with a request body and getting Response
		String str = restTemplate.postForObject(REST_SERVICE_URI + "addEmp",emp, String.class);
		System.out.println("String Returned : " + str);
	}

	//PUT 
	private static void updateEmployee() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		EmployeeBean employee =  new EmployeeBean(1003,"TestMSD","Manager",new Date(),1000.0);
		//Placing Request with a request body for Update
		restTemplate.put(REST_SERVICE_URI + "updateEmp", employee);
		System.out.println(employee);
	}

	//DELETE 
	private static void deleteEmployee() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		//Placing Request with a request body for deletion of Employee
		restTemplate.delete(REST_SERVICE_URI + "deleteEmp/1005");
		System.out.println("Deleted Successfuly!!!");
	}

	public static void main(String args[]) {
		listAllEmployees();
		//getEmployee();
		//createEmployee();
		
		// updateEmployee();
		//System.out.println("--------------");
		//listAllEmployees();
		//deleteEmployee();
		
		
	}
}
//Step1 please don't put extra slashes in the end
//Step2  for appropriate request method on server side please choose appropriate request method
//example to invoke get method on server please use the getmethod on client
//Step3  please updated the employeeIds to be created/ updated/ deleted in the end of every URL
//put and delete do not return any thing hence showing null
