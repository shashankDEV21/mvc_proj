package com.accenture.lkm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.LoginBean;
import com.accenture.lkm.dao.LoginDAO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

		public String validateLogin(LoginBean loginBean){
			
			return loginDAO.validateLogin(loginBean);
			
		}
	
	
}
