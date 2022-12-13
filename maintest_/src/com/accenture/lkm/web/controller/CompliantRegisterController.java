package com.accenture.lkm.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CompliantBean;
import com.accenture.lkm.service.CompliantService;

@Controller
public class CompliantRegisterController {

	@Autowired
	 CompliantService cs;
	@RequestMapping(value="loadform.html")
	public ModelAndView loadCompliantForm() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("CompliantPage");
		mv.addObject("cbean", new CompliantBean());
		return mv;
	}
	
	@RequestMapping(value="processform.html" , method=RequestMethod.POST)
   public ModelAndView processCompliantForm(@ModelAttribute("cbean")@Valid CompliantBean cbean,BindingResult res) throws Exception {
       ModelAndView mv=new ModelAndView();
	   if(res.hasErrors()) {
    	   mv.setViewName("CompliantPage");
       }
	   else {
		   cs.registerCompliantDetails(cbean);
		   mv.setViewName("Success");
		   mv.addObject("message", "Hi "+cbean.getCustomerName()+" your Compliant is successfuly registered");
	   }
	   return mv;
   }
	@ModelAttribute("types")
	public Map<Integer,String> getAllCompliantTypes(){
	
		return cs.getAllCompliantTypes();
		
	}
	
	
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	
}
