package com.accenture.lkm.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tester1003 {
	public static final String REST_SERVICE_URI = "http://localhost:8080/Demo_10031_Spring_MVC_REST_CRUD_JPA_Data_XML/emp/controller/";
	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllEmployees() {
		System.out.println("Testing listAllUsers API-----------");

		RestTemplate restTemplate = new RestTemplate();
		//Hitting the Server URL and getting the response
		
		ResponseEntity<List> employeeMapRespEntity = 
				restTemplate.exchange(REST_SERVICE_URI + "getDetails",
						HttpMethod.GET, null,List.class); 
		List<LinkedHashMap<String, Object>>  employeeMap = employeeMapRespEntity.getBody();
		
		//mapper to covert Object to a specific type  
		ObjectMapper mapper =  new ObjectMapper();
		List<EmployeeBean> list  = new ArrayList<EmployeeBean>();
		
		if (employeeMap != null) {
			for (LinkedHashMap<String, Object> map : employeeMap) {
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
		ResponseEntity<EmployeeBean> respEmployeeBean= 
				restTemplate.exchange(REST_SERVICE_URI + "getDetailsById/1003", HttpMethod.GET, null,EmployeeBean.class);
		EmployeeBean emp = respEmployeeBean.getBody();
		System.out.println(emp);
	}

	 //POST 
	private static void createEmployee() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		EmployeeBean emp = new EmployeeBean(0,"TestMSD","Manager",new Date(),1000.0);
		//Placing Request with a request body and getting Response
		HttpEntity<EmployeeBean> requestEntity =  new HttpEntity<EmployeeBean>(emp);
		
		ResponseEntity<String> respString= restTemplate.exchange(REST_SERVICE_URI + "addEmp", HttpMethod.POST, requestEntity,String.class);
		String str =  respString.getBody();
		System.out.println("String Returned : " + str);
		
	}

	//PUT 
	private static void updateEmployee() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		EmployeeBean employee =  new EmployeeBean(1003,"TestMSD","Manager",new Date(),2000.0);
		HttpEntity<EmployeeBean> requestEntity =  new HttpEntity<EmployeeBean>(employee);
		//Placing Request with a request body for Update
		ResponseEntity<EmployeeBean> respEmployeeBean = 
				restTemplate.exchange(REST_SERVICE_URI + "updateEmp", HttpMethod.PUT, requestEntity,EmployeeBean.class);
		EmployeeBean employeeBean2 =  respEmployeeBean.getBody();
		System.out.println(employeeBean2);
	}

	//DELETE 
	private static void deleteEmployee() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		
		// write handler before the operation is performed
		restTemplate.setErrorHandler(new ResponseErrorHandler(){
			
			// This method defines whether the handler should handle the error or skip it
			// handler handles the error if this method returns true
			@Override
			public boolean hasError(ClientHttpResponse arg0) throws IOException {
				boolean bool=false;
				if(arg0.getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR){
					bool =true;
				}
				System.out.println("hasError(ClientHttpResponse arg0) boolean: "+arg0);
				return bool;
			}
			// This method handles the error
			@Override
			public void handleError(ClientHttpResponse arg0) throws IOException {
				System.out.println("handleError(ClientHttpResponse arg0) void: "+arg0);
				throw new RuntimeException("Please give a valid id to delete, server returned: "+arg0.getStatusCode());
				
			}
		});
		
		//Placing Request with a request body for deletion of Employee
		ResponseEntity<EmployeeBean> respEmployeeBean = 
				restTemplate.exchange(REST_SERVICE_URI +"deleteEmp/1005", HttpMethod.DELETE, null,EmployeeBean.class);
		EmployeeBean employeeBean2 =  respEmployeeBean.getBody();
		System.out.println("Deleted Successfuly: "+employeeBean2);
	}

	public static void main(String args[]) {
		//listAllEmployees();
		//getEmployee();
		//createEmployee();
		 //updateEmployee();
		//deleteEmployee();
		
		
	}
}
//Step1 please don't put extra slashes in the end
//Step2  for appropriate request method on server side please choose appropriate request method
//example to invoke get method on server please use the getmethod on client
//Step3  please updated the employeeIds to be created/ updated/ deleted in the end of every URL
//put and delete do not return any thing hence showing null
