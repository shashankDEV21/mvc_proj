package com.accenture.lkm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.bean.Usser;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login.htm" , method = RequestMethod.GET)
	public String loadLoginPage(@ModelAttribute("usser")Usser ussr)
	{
		//Usser user = new Usser();
		//map.addAttribute(user);
		//map.addAttribute("userBean", user);
		//ModelAndView modelAndView = new ModelAndView("login","usser",user);//url,attributeName, object
		//return modelAndView;
		return "login";
	}
	
	@RequestMapping(value = "validateLogin.htm" , method = RequestMethod.POST)
	public ModelAndView validateLogin(@ModelAttribute("user1") Usser use)
	{
		ModelAndView modelAndView = new ModelAndView();
		if("System".equalsIgnoreCase(use.getUserName()) && "System@123".equals(use.getPassword()))
		{
			modelAndView.setViewName("success");
			modelAndView.addObject("message","Welcome, "+use.getUserName());
		}
		else
		{
			modelAndView.setViewName("failure");
			modelAndView.addObject("errorMessage","Enter valid password "+use.getUserName());
		}
		return modelAndView;
	}

}
