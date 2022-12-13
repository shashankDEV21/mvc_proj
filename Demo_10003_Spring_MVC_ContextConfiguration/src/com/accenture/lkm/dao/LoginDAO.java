package com.accenture.lkm.dao;

import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.LoginBean;

@Repository
public class LoginDAO {

	public String validateLogin(LoginBean loginBean){
		
		String uName = loginBean.getUserName();
		String password = loginBean.getPassword();
		
		if(uName.equals("MSD") && password.equals("MSD@123")){
			return "success";
		}
		else{
			return "failure";
		}
	}
}
