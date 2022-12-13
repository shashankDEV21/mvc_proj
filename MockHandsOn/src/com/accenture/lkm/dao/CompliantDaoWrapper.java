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
	private CompliantDao cdao;
	
	@Autowired
	private CompliantTypeDao ctdao;
	
	@PersistenceContext
	private EntityManager em;
	
	public void registerCompliantDetails(CompliantBean compliantBean) {
		
	 CompliantEntity compliantEntity=convertCompliantBeantoEntity(compliantBean);
		 if(compliantEntity!=null) {
			 cdao.save(compliantEntity);
		 }
	
	}
	
//	List<CompliantBean>getCompliantDetailsByDate(Date fromDate, Date toDate){
//		
//	}
	
 public	List<CompliantTypeBean> getAllCompliantTypes(){
		List<CompliantTypeEntity> list=ctdao.findAll();
	   List<CompliantTypeBean> ctblist=new ArrayList<>();
		if(!list.isEmpty()) {
			for(CompliantTypeEntity ct:list) {
				CompliantTypeBean ctb=convertCompliantTypeEntitytoBean(ct);
				ctblist.add(ctb);
			}
		}
		return ctblist;
	}
	
	
	public int getCustomerByCompliantType(String customerName,int compliantTypeId) {
		CompliantEntity ct=cdao.getCustomerByCompliantType(customerName, compliantTypeId);
		if(ct!=null) {
			return 1;
		}
		return 0;
	}
	
	public List<CompliantBean> getCompliantDetailsByDate(Date fromDate,Date toDate){
		List<CompliantEntity> compliantEntities=cdao.getCompliantDetailsByDate(fromDate, toDate);
		List<CompliantBean> compliantBeans=new ArrayList<CompliantBean>();
		for(CompliantEntity entity:compliantEntities) {
			CompliantBean bean=convertCompliantEntityToBean(entity);
			compliantBeans.add(bean);
		}
		return compliantBeans;
	}
	

	
	public CompliantEntity convertCompliantBeantoEntity(CompliantBean cb) {
		CompliantEntity ct=new CompliantEntity();
		BeanUtils.copyProperties(cb, ct);
		return ct;
	}
	public CompliantTypeBean convertCompliantTypeEntitytoBean(CompliantTypeEntity cte) {
		CompliantTypeBean ctb=new CompliantTypeBean();
		BeanUtils.copyProperties(cte, ctb);
		return ctb;
	}
	
	public CompliantBean convertCompliantEntityToBean(CompliantEntity ct) {
		CompliantBean b=new CompliantBean();
		BeanUtils.copyProperties(ct, b);
		return b;
	}
}
