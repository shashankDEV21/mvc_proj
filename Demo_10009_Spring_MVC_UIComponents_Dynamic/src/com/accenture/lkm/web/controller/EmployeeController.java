package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	//Default method is Get
	@RequestMapping("/loadEmployeeRegistrationPage")
	public ModelAndView showRegistrationPage() {
		System.out.println("in showRegistrationPage()");
		EmployeeBean employeeBean = new EmployeeBean();
		return new ModelAndView("Registration", "employeeBean", employeeBean);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("employeeBean") EmployeeBean employeeBean) {
		System.out.println("in register()");
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("RegistrationSuccess");
		modelAndView.addObject("message", "Welcome: " + employeeBean.getName());

		return modelAndView;

	}

	// 1 Dynamic DropDown - Different Labels and values 
	//[Map key->value of control, Map value-> label of control]
	@ModelAttribute("countryList")
	public Map<String, String> populateCountries() {
		System.out.println("**Country Map Initialized***");
		return employeeService.getCountries();
	}

	// 1 Dynamic DropDown - Same label and values
	@ModelAttribute("countryListSameNameAndValue")
	public List<String> populateCountriesSameValueAndLabel() {
		System.out.println("**Country List Initialized***");
		/*List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("India","Canada","Monaco"));
		return list;*/
		return employeeService.getCountriesSameValueAndLabel();
	}

	// 2 Dynamic Check boxes - Different Labels and values
	//[Map key->value of control, Map value-> label of control]
	@ModelAttribute("communityList")
	public Map<String, String> populateCommuityCheckBoxes() {
		System.out.println("**CommunityList List Initialized***");
		return employeeService.getCommunities();
	}

	// 3 Dynamic Radio Buttons
	//[Map key->value of control, Map value-> label of control]
	@ModelAttribute("gender")
	public Map<String, String> populateGenderRadio() {
		System.out.println("**Gender Map Initialized***");
		return employeeService.getGender();
	}

}