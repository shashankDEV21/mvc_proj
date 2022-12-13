//package com.accenture.lkm.web.controller;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.accenture.lkm.business.bean.EmployeeBean;
//import com.accenture.lkm.exceptions.InvalidUpdateOperationException;
//import com.accenture.lkm.service.EmployeeService;
//
//@Controller
//public class FakeController {
//
//	@Autowired
//	private EmployeeService es;
//	
//	@InitBinder
//	public void InitBinder(WebDataBinder binder) {
//		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy");
//		binder.registerCustomEditor(Date.class,"insertTime",new CustomDateEditor(sf,true));
//	}
//	
//	@RequestMapping(value="/LoadSaveEmployee", method=RequestMethod.GET)
//	public ModelAndView load() throws Exception {
//		ModelAndView mv=new ModelAndView();
//		EmployeeBean bean=new EmployeeBean();
//		mv.setViewName("CreateEmployee");
//		mv.addObject("empBean",bean);
//		return mv;
//	}
//	
//	@RequestMapping(value="/saveEmployee", method=RequestMethod.GET)
//	public ModelAndView save(@ModelAttribute("empObj")EmployeeBean bean) throws Exception {
//		ModelAndView mv=new ModelAndView();
//		//EmployeeBean bean=new EmployeeBean();
//		int i=es.addEmployee(bean);
//		mv.setViewName("CreateEmployeeSuccess");
//		mv.addObject("message","Welcome "+i);
//		return mv;
//	}
//	
//	@RequestMapping(value="/GetDetails", method=RequestMethod.GET)
//	public ModelAndView getDetails() throws Exception {
//		List<EmployeeBean>li=es.getEmployeeList();
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("GetAllEmployeeDetails");
//		mv.addObject("empBean",li);
//		return mv;
//	}
//	
//	@RequestMapping(value="/LoadUpdateEmployee", method=RequestMethod.GET)
//	public ModelAndView updateEmployee() throws Exception {
//		ModelAndView mv=new ModelAndView();
//		EmployeeBean bean=new EmployeeBean();
//		mv.setViewName("UpdateEmployee");
//		mv.addObject("empBean",bean);
//		return mv;
//	}
//	@RequestMapping(value="/LoadUpdateEmployee2", method=RequestMethod.POST)
//	public ModelAndView loadupdate(@ModelAttribute("empBean")EmployeeBean bean) throws Exception {
//		EmployeeBean b=es.getEmployeeDetails(bean.getId());
//		ModelAndView mv=new ModelAndView();
//		//EmployeeBean bean=new EmployeeBean();
//		mv.setViewName("UpdateEmployee");
//		mv.addObject("empBean2",b);
//		return mv;
//	}
//	
//	@RequestMapping(value="/UpdateEmployee", method=RequestMethod.POST)
//	public ModelAndView update(@ModelAttribute("empBean2")EmployeeBean bean) throws Exception {
//		EmployeeBean be=es.updateEmployeeDetails(bean);
//		//EmployeeBean bean=new EmployeeBean();
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("UpdateEmployeeSuccess");
//		return mv;
//	}
//    
//	@ExceptionHandler(value=InvalidUpdateOperationException.class)
//	public ModelAndView getexception(InvalidUpdateOperationException ex) {
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("message",ex.getMessage());
//		mv.addObject("exception",ex);
//		mv.setViewName("UpdateEmployee");
//		return mv;
//	}
//	
//}
