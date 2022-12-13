package com.accenture.lkm.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Tester1002 {
	public static final String REST_SERVICE_URI = "http://localhost:8080/Demo_10031_Spring_MVC_REST_CRUD_JPA_Data_XML//emp/controller/";

	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllEmployees() {
		System.out.println("Testing listAllUsers API-----------");
		RestTemplate restTemplate = new RestTemplate();
		// Hitting the Server URL and getting the response
		List<LinkedHashMap<String, Object>> employeeMap = restTemplate.getForObject(REST_SERVICE_URI + "getDetails",
				List.class);

		// mapper to covert Object to a specific type
		/*System.out.println("employeeMap " + employeeMap);
		System.out.println();*/
		
		ObjectMapper mapper = new ObjectMapper();
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		if (employeeMap != null) {
			for (LinkedHashMap<String, Object> map : employeeMap) {
				//System.out.println("\t map: " + map);
				// Map object should be converted to Employee type
				EmployeeBean emp = mapper.convertValue(map, EmployeeBean.class);
				//System.out.println("\t emp: " + emp);
				list.add(emp);
			}
			System.out.println("Employee Details are: \n" + list);
		} else {
			System.out.println("No user exist----------");
		}
		
	}

	@SuppressWarnings("unchecked")
	private static void listAllEmployees2() {
		System.out.println("Testing listAllUsers API-----------");
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<EmployeeBean[]> response = restTemplate.getForEntity(REST_SERVICE_URI + "getDetails",EmployeeBean[].class);
		List<EmployeeBean> responseEmployeeBeanList = Arrays.asList(response.getBody());
		System.out.println("using getForEntity() list: \n" + responseEmployeeBeanList);
		System.out.println();
	}

	// GET
	private static void getEmployee() {
		System.out.println("Testing getEmployee----------");
		RestTemplate restTemplate = new RestTemplate();
		// Placing Request and getting response
		EmployeeBean emp = restTemplate.getForObject(REST_SERVICE_URI + "getDetailsById/1003", EmployeeBean.class);
		System.out.println(emp);
	}

	// POST
	private static void createEmployee() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		EmployeeBean employee = new EmployeeBean(0, "TestMSD", "Manager", new Date(), 1000.0);
		// Placing Request with a request body and getting Response
		String str = restTemplate.postForObject(REST_SERVICE_URI + "addEmp", employee, String.class);
		System.out.println("String Returned : " + str);
	}

	// PUT
	private static void updateEmployee() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		EmployeeBean employee = new EmployeeBean(1002, "TestMSD", "Manager", new Date(), 1000.0);
		// Placing Request with a request body for Update
		restTemplate.put(REST_SERVICE_URI + "updateEmp", employee);
		System.out.println(employee);
	}

	// DELETE
	private static void deleteEmployee() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();

		// write handler before the operation is performed
		restTemplate.setErrorHandler(new ResponseErrorHandler() {  //inner class

			// This method defines whether the handler should handle the error or skip it
			// handler handles the error if this method returns true
			@Override
			public boolean hasError(ClientHttpResponse arg0) throws IOException {
				boolean bool = false;
				if (arg0.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
					bool = true;
				}
				System.out.println("hasError(ClientHttpResponse arg0) boolean: " + arg0);
				return bool;
			}

			// This method handles the error
			@Override
			public void handleError(ClientHttpResponse arg0) throws IOException {
				System.out.println("handleError(ClientHttpResponse arg0) void: " + arg0);
				throw new RuntimeException(
						"Please give a valid id to delete, server returned: " + arg0.getStatusCode());

			}
		});

		// Placing Request with a request body for deletion of Employee
		restTemplate.delete(REST_SERVICE_URI + "deleteEmp/10005");

		System.out.println("Deleted Successfuly!!!");
	}

	public static void main(String args[]) {
		//listAllEmployees();//using getForObject();
		listAllEmployees2();//using getForEntity();
		// getEmployee();
		
		// createEmployee();
		// updateEmployee();
		 //deleteEmployee();

	}
}
// Step1 please don't put extra slashes in the end
// Step2 for appropriate request method on server side please choose appropriate
// request method
// example to invoke get method on server please use the getmethod on client
// Step3 please updated the employeeIds to be created/ updated/ deleted in the
// end of every URL
// put and delete do not return any thing hence showing null
