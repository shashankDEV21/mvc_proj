package com.accenture.lkm.business.bean;

public class LoginBean {
	
	private String userName="Kiran";
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginBean(){
		System.out.println("Instatiated......");
	}
}
