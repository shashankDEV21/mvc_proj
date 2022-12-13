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
	private CompliantDaoWrapper cdw;

	@Override
	public void registerCompliantDetails(CompliantBean compliantBean)throws Exception {
		// TODO Auto-generated method stub
    int s=cdw.getCustomerByCompliantType(compliantBean.getCustomerName(), compliantBean.getCompliantTypeId());
	if(s==1) {
		throw new Exception ("Hi "+compliantBean.getCustomerName()+", you have already submitted a compliant with same compliant type");
	}else {
		cdw.registerCompliantDetails(compliantBean);
	}
	}

	@Override
	public List<CompliantBean> getCompliantDetailsByDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		List<CompliantBean> compliantBeans=cdw.getCompliantDetailsByDate(fromDate, toDate);
		return compliantBeans;
	}

	@Override
	public Map<Integer, String> getAllCompliantDetails() {
     		// TODO Auto-generated method stub
	    List<CompliantTypeBean> li=cdw.getAllCompliantTypes();
	    Map<Integer,String>map=new HashMap<>();

		for(CompliantTypeBean b:li) {
			map.put(b.getCompliantTypeId(), b.getCompliantTypeName());
		}
		return map;
	}
	
}
