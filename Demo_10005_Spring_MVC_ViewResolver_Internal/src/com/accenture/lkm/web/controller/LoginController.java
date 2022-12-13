package com.accenture.lkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService; 
	//Returning the ModelAndView with logical view name
	//Will return ModelAndView to DispatcherServlet
	//DispatcherServlet will take help of the ViewResolver to 
	// resolve the logical view name to the actual view 
	
	@RequestMapping(value = "/loadLogin.html", method = RequestMethod.GET)
	public ModelAndView loadLoginPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	//Returning the ModelAndView with logical view name
	@RequestMapping(value = "/validateLogin.html", method=RequestMethod.POST)
	public ModelAndView validateLogin(@RequestParam("uName")String userName, @RequestParam("pwd")String password) {

		LoginBean loginBean = new LoginBean();
		loginBean.setPassword(password);
		loginBean.setUserName(userName);
		
		String returnVal = loginService.validateLogin(loginBean);

		ModelAndView modelAndView = new ModelAndView();

		if (returnVal.equals("success")) {
			modelAndView.setViewName("success");
			modelAndView.addObject("message", 
					"Welcome: " + userName);
		} else {
			modelAndView.setViewName("failure");
			modelAndView.addObject("errorMessage","Please Login again with valid credentials");
		}
		return modelAndView;

	}
}