package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.CompliantBean;
import com.accenture.lkm.business.bean.CompliantTypeBean;
import com.accenture.lkm.entity.CompliantEntity;
import com.accenture.lkm.entity.CompliantTypeEntity;

@Repository
@Transactional(value="txManager")
public class CompliantDaoWrapper {

	@Autowired
	 CompliantDao cdao;
	
	@Autowired
	 CompliantTypeDao ctdao;
	
//	@PersistenceContext
//	EntityManager em;
	
	public void registerCompliantDetails(CompliantBean cbean) {
		CompliantEntity ct=convertCbeantoEntity(cbean);
		cdao.save(ct);
	}
	
	public List<CompliantBean> getCompliantDetailsByDate(Date fromDate,Date toDate){
	List<CompliantEntity>ctli=cdao.getCompliantDetailsByDate(fromDate, toDate);
	List<CompliantBean>list=new ArrayList<>();
	for(CompliantEntity ct:ctli) {
		CompliantBean cb=convertCEntitytoBean(ct);
		list.add(cb);
	}
	return list;
	}
	
	public List<CompliantTypeBean> getAllCompliantTypes(){
		List<CompliantTypeEntity> cte=ctdao.findAll();
		List<CompliantTypeBean>li=new ArrayList<>();
		for(CompliantTypeEntity t:cte) {
			CompliantTypeBean bean=convertTypeEntitytoBean(t);
			li.add(bean);
		}
		return li;
	}
	
	public int getCustomerByCompliantType(String customerName,Integer compliantTypeId) {
		CompliantEntity ct=cdao.getCustomerByCompliantType(customerName, compliantTypeId);
		if(ct==null) {
			return 0;
		}
		return 1;
	}
	
	
	public CompliantEntity convertCbeantoEntity(CompliantBean b) {
		CompliantEntity t=new CompliantEntity();
		BeanUtils.copyProperties(b, t);
       return t;				
	}
	public CompliantBean convertCEntitytoBean(CompliantEntity ct) {
		CompliantBean b=new CompliantBean();
		BeanUtils.copyProperties(ct,b);
       return b;				
	}
	
	public CompliantTypeBean convertTypeEntitytoBean(CompliantTypeEntity cte) {
		CompliantTypeBean ctb=new CompliantTypeBean();
		BeanUtils.copyProperties(cte, ctb);
       return ctb;				
	}
}
