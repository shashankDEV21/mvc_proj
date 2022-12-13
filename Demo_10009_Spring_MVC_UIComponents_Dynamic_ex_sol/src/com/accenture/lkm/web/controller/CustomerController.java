package com.accenture.lkm.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	//Default method is Get
	@RequestMapping("/loadCustomerRegistrationPage")
	public ModelAndView showRegistrationPage() {
		CustomerBean customerBean = new CustomerBean();
		return new ModelAndView("Registration", "customerBean", customerBean);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("customerBean") CustomerBean customerBean) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("RegistrationSuccess");
		modelAndView.addObject("message", "Welcome: " + customerBean.getCustomerName());

		return modelAndView;

	}

	// 1 Dynamic DropDown - Different Labels and values 
	//[Map key->value of control, Map value-> label of control]
	@ModelAttribute("customerTypeList")
	public Map<String, String> populateCustomerType() {
		System.out.println("**Customer Map Initialized***");
		return customerService.getCustomerType();
	}

	// 1 Dynamic DropDown - Same label and values
	@ModelAttribute("customerTypeListSameNameAndValue")
	public List<String> populateCustomerTypeSameValueAndLabel() {
		System.out.println("**Customer List Initialized***");
		return customerService.getCustomerTypeSameValueAndLabel();
	}

	// 2 Dynamic Check boxes - Different Labels and values
	//[Map key->value of control, Map value-> label of control]
	@ModelAttribute("customerServicesList")
	public Map<String, String> populateCustomerServicesCheckBoxes() {
		System.out.println("**CommunityList List Initialized***");
		return customerService.getCustomerServices();
	}

	// 3 Dynamic Radio Buttons
	//[Map key->value of control, Map value-> label of control]
	@ModelAttribute("gender")
	public Map<String, String> populateGenderRadio() {
		System.out.println("**Gender Map Initialized***");
		return customerService.getGender();
	}

}