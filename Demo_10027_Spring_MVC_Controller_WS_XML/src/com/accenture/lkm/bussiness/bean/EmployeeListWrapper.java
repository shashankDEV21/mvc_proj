package com.accenture.lkm.bussiness.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeListWrapper {
	private List<EmployeeBean> listEmp;

	@XmlElement(name="employee") // rename the child elements in the list
	public List<EmployeeBean> getListEmp() {
		return listEmp;
	}

	public void setListEmp(List<EmployeeBean> listEmp) {
		this.listEmp = listEmp;
	}
	

}
