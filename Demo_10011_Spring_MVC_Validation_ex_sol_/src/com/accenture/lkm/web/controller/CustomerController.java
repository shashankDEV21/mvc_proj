package com.accenture.lkm.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public ModelAndView register(@Valid @ModelAttribute("customerBean") CustomerBean customerBean,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		String pageName = "";
		if (result.hasErrors()) {
			pageName = "Registration";
		} else {
			modelAndView.addObject("message", "Welcome: " + customerBean.getCustomerName());
			pageName = "RegistrationSuccess";
		}
		modelAndView.setViewName(pageName);
		return modelAndView;
	}
}