package com.accenture.lkm.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String loadLoginPage(Model map) {
		map.addAttribute(new LoginBean());
		return "login";
	}
	
	//Returning the ModelAndView with logical view name
	@RequestMapping(value = "/validateLogin.html", method = RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("loginBean")LoginBean paramBean,HttpServletRequest req, ModelMap map) {
		
		System.out.println("ModelMap Data");
		System.out.println("=============");
		System.out.println(map);// loginbean object inside map
		
		System.out.println("Request Data");
		System.out.println("=============");
		System.out.println("req.getAttribute(\"loginBean\"): "+req.getAttribute("loginBean")); // null or loginBean object?
		
		//uncomment to know the details of the attributes
		/*Enumeration reqEnum = req.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement()+"";
			System.out.println(s);
			System.out.println("==" + req.getAttribute(s));
		}*/
		String returnVal = loginService.validateLogin(paramBean);
		ModelAndView modelAndView = new ModelAndView();
		if (returnVal.equals("success")) {
			modelAndView.setViewName("success");
			modelAndView.addObject("message", "Welcome: " + paramBean.getUserName());
		} else {
			modelAndView.setViewName("failure");
			modelAndView.addObject("errorMessage","Please Login again with valid credentials");
		}
		return modelAndView; // after this model data added to request scope

	}
}