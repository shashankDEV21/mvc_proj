package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CompliantBean;
import com.accenture.lkm.business.bean.DateRangeBean;
import com.accenture.lkm.service.CompliantService;

@Controller
public class CompliantReportController {

	@Autowired
	CompliantService cs;
      
	@RequestMapping("loadreport")
	public ModelAndView loadCompliantReport() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ComppliantReport");
		mv.addObject("daterange", new DateRangeBean());
		return mv;
	}
	@RequestMapping(value="showdetails.html", method=RequestMethod.POST)
	public ModelAndView getCompliantDetailsByDate(@ModelAttribute("daterange")DateRangeBean daterange) {
		ModelAndView mv=new ModelAndView();
	List<CompliantBean>li=	cs.getCompliantDetailsByDate(daterange.getFromDate(), daterange.getToDate());
		mv.setViewName("ShowCompliantDetails");
		mv.addObject("list", li);
		return mv;
}
}