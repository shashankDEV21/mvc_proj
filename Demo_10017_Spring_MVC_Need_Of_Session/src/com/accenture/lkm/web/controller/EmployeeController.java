package com.accenture.lkm.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.EmployeeBean;

@Controller
public class EmployeeController {
	
	//Default method is Get
	@RequestMapping("/loadEmployeeRegistrationPage")
	public ModelAndView showRegistrationPage() {
		return new ModelAndView("Registration", "employeeBean",	new EmployeeBean());
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("employeeBean") EmployeeBean employeeBean,ModelMap map,HttpServletRequest req) {
		System.out.println("Register Handler");
		System.out.println("================");
		System.out.println("Model Data: "+map.get("employeeBean"));
		System.out.println("Request: "+req.getAttribute("employeeBean"));
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("RegistrationSuccess");
		modelAndView.addObject("message", "Welcome: " + employeeBean.getName());
		return modelAndView;
	}
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public ModelAndView confirmDetails(@ModelAttribute("employeeBean") EmployeeBean employeeBean,ModelMap map,HttpServletRequest req,HttpSession sess) {
		System.out.println("\nConfirm Details Handler");
		System.out.println("========================");
		System.out.println("Model Data: "+map.get("employeeBean"));
		System.out.println("Request: "+req.getAttribute("employeeBean"));
		System.out.println("Session: "+sess.getAttribute("employeeBean"));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ConfirmDetails");
		modelAndView.addObject("message", "Welcome to confirm Details: " + employeeBean.getName());
		return modelAndView;
	}
	
}