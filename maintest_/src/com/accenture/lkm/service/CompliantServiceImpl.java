package com.accenture.lkm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.CompliantBean;
import com.accenture.lkm.business.bean.CompliantTypeBean;
import com.accenture.lkm.dao.CompliantDaoWrapper;

@Service
public class CompliantServiceImpl implements CompliantService{

	@Autowired
private	CompliantDaoWrapper cdw;
	
	@Override
	public void registerCompliantDetails(CompliantBean cbean) throws Exception {
		// TODO Auto-generated method stub
		int i=cdw.getCustomerByCompliantType(cbean.getCustomerName(), cbean.getCompliantTypeId());
		if(i==1) {
			throw new Exception("Hi "+ cbean.getCustomerName()+", you already submitted compliant with same compliant Type");
		}else {
			cdw.registerCompliantDetails(cbean);
		}
	}

	@Override
	public List<CompliantBean> getCompliantDetailsByDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return cdw.getCompliantDetailsByDate(fromDate, toDate);
	
	}

	@Override
	public Map<Integer, String> getAllCompliantTypes() {
		// TODO Auto-generated method stub
		List<CompliantTypeBean> ctb=cdw.getAllCompliantTypes();
		Map<Integer,String> map=new HashMap<Integer, String>();
		for(CompliantTypeBean cb:ctb) {
			map.put(cb.getCompliantTypeId(), cb.getCompliantTypeName());
		}
		
		return map;
	}
	
}
