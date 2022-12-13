package com.accenture.lkm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping("login.html")
	public String loadLogin(@ModelAttribute("loginbean")LoginBean lg) {
//		LoginBean loginBean = new LoginBean();
//		//map.addAttribute("login",loginBean);
//		map.addAttribute(loginBean);//key=>loginBean
		return "login.jsp";
		}
	
	

	//	@RequestMapping(value = "/validateLogin.html", method = RequestMethod.POST)
//	
//	public ModelAndView validateLogin(@RequestParam("userName")String uName,@RequestParam("password")String pass) {
////		
//		LoginBean loginBean=new LoginBean();
//		loginBean.setUserName(uName);
//		loginBean.setPassword(pass);
//		String returnValue = loginService.validateLogin(loginBean);
//
//		ModelAndView modelAndView = new ModelAndView();
//
//		if (returnValue.equals("success")) {
//			modelAndView.setViewName("success.jsp");
//			modelAndView.addObject("message", "Welcome: " + loginBean.getUserName());
//		} else {
//			modelAndView.setViewName("failure.jsp");
//			modelAndView.addObject("errorMessage","Please Login again with valid credentials");
//			
//		}
//		return modelAndView;
//
//	}
	
	@RequestMapping(value = "/validateLogin.html", method = RequestMethod.POST)
	
	public ModelAndView validateLogin( LoginBean loginbean) {
//		
		
//		loginBean.setUserName(uName);
//		loginBean.setPassword(pass);
		ModelAndView modelAndView = new ModelAndView();
		if("System".equalsIgnoreCase(loginbean.getUserName()) && "System@123".equals(loginbean.getPassword()))
		{
			modelAndView.setViewName("success.jsp");
			modelAndView.addObject("message","Welcome, "+loginbean.getUserName());
		}
		else
		{
			modelAndView.setViewName("failure.jsp");
			modelAndView.addObject("errorMessage","Enter valid password "+loginbean.getUserName());
		}
		return modelAndView;

	}

	
	/*public ModelAndView validateLogin(
	@RequestParam("uName")String userName,
	@RequestParam("pwd")String password) {*/

	/*LoginBean loginBean = new LoginBean();
loginBean.setPassword(password);
loginBean.setUserName(userName);*/

	
	/*@RequestMapping(value = "/validateLogin.html", method = RequestMethod.POST)
	public ModelAndView validateLogin(
			HttpServletRequest request, HttpServletResponse response) {
		
		String userName= request.getParameter("uName");
		String password= request.getParameter("pwd");
	
		LoginBean loginBean = new LoginBean();
		loginBean.setPassword(password);
		loginBean.setUserName(userName);
		
		String returnValue = loginService.validateLogin(loginBean);

		ModelAndView modelAndView = new ModelAndView();

		if (returnValue.equals("success")) {
			modelAndView.setViewName("success.jsp");
			modelAndView.addObject("message", "Welcome: " + loginBean.getUserName());
		} else {
			modelAndView.setViewName("failure.jsp");
			modelAndView.addObject("errorMessage","Please Login again with valid credentials");
			
		}
		return modelAndView;

	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}