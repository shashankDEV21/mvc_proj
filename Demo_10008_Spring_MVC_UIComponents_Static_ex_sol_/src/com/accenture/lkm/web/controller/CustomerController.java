package com.accenture.lkm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CustomerBean;

@Controller
public class CustomerController {
	
	//Default method is Get
	@RequestMapping("/loadCustomerRegistrationPage")
	public ModelAndView showRegistrationPage() {
		return new ModelAndView("Registration", "customerBean",	new CustomerBean());
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("customerBean") CustomerBean customerBean) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("RegistrationSuccess");
		modelAndView.addObject("message", "Welcome: " + customerBean.getCustomerName());
		return modelAndView;
	}
}