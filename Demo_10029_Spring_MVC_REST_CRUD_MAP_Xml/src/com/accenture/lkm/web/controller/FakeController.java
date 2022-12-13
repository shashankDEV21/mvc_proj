//package com.accenture.lkm.web.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.xml.ws.Response;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.accenture.lkm.bussiness.bean.EmployeeBean;
//import com.accenture.lkm.service.EmployeeService;
//
//@RestController
//public class FakeController {
// 
//	@Autowired
//	private EmployeeService es;
//	
//	@RequestMapping(value="emp/controller/getDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<EmployeeBean>> getEmployeeDetails() {
//		List<EmployeeBean> li=new ArrayList<>(es.getAllEmployee());
//		return new ResponseEntity<List<EmployeeBean>>(li,HttpStatus.OK);
//		
//	}
//	
//	@RequestMapping(value="emp/controller/getDetailsById/{id}", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<EmployeeBean> getEmpl(@PathVariable("id")int id){
//	 EmployeeBean b=es.getEmployeeDetailsById(id);
//	 if(b!=null)
//		return new ResponseEntity<EmployeeBean>(b,HttpStatus.OK);
//	 return new ResponseEntity<EmployeeBean>(b,HttpStatus.NOT_FOUND);
//	}
//	
//	@RequestMapping(value="emp/controller/addEmp",method=RequestMethod.POST,consumes= {MediaType.APPLICATION_JSON_VALUE},produces= {MediaType.TEXT_HTML_VALUE})
//	public ResponseEntity<String> addEmp(@RequestBody EmployeeBean bean){
//		int c=es.addEmployee(bean);
//		return new ResponseEntity<String>("new Empl added with id "+c,HttpStatus.CREATED);
//	}
//	
//	@RequestMapping(value="",method=RequestMethod.PUT,consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<EmployeeBean> update(@RequestBody EmployeeBean bean){
//	//EmployeeBean b=	es.updateEmployee(bean);
//	if(es.getEmployeeDetailsById(bean.getEmployeeId())==null) {
//		EmployeeBean bg=null;
//		return new ResponseEntity<EmployeeBean>(bg,HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//	
//	EmployeeBean b=es.updateEmployee(bean);
//	return new ResponseEntity<EmployeeBean>(b,HttpStatus.OK);
//	}
//	
//	public ResponseEntity<EmployeeBean> delete(int id){
//	}
//	
//}
