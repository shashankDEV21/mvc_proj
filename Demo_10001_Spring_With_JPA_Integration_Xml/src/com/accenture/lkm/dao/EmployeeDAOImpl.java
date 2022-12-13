package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.entity.EmployeeEntity;
@Repository
@SuppressWarnings("unchecked")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public Integer addEmployee(EmployeeBean employeeBean) throws Exception{
		// TODO Auto-generated method stub
		Integer employeeID = 0;
		EntityManager entityManager = null;
		
		EmployeeEntity employeeEntityBean =convertBeanToEntity(employeeBean);
		try {
			entityManager =entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
				entityManager.persist(employeeEntityBean);
				employeeEntityBean.setName("John");
				entityManager.getTransaction().commit();
			employeeID = employeeEntityBean.getId();
		} catch (Exception exception) {
			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		
		return employeeID;
	}
	
	public EmployeeBean getEmployeeDetails(Integer id) throws Exception{
		// TODO Auto-generated method stub
		EmployeeBean employeeBean = null;
		EntityManager entityManager = null;
		try {
			entityManager =entityManagerFactory.createEntityManager();
			EmployeeEntity employeeEntity = (EmployeeEntity) entityManager.find(EmployeeEntity.class, id);

			if(employeeEntity!=null){
				employeeBean=convertEntityToBean(employeeEntity);
			}
			
		} catch (Exception exception) {

			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		

		return employeeBean;
	}
	
	
	
	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception{
		// TODO Auto-generated method stub
		EmployeeBean employeeBean2 = null;
		EntityManager entityManager = null;
		try {
			entityManager =entityManagerFactory.createEntityManager();
			EmployeeEntity employeeEntityBean2 = entityManager.find(EmployeeEntity.class, employeeBean.getId());
			if(employeeEntityBean2 != null)
			
			{	entityManager.getTransaction().begin();
					employeeEntityBean2.setInsertTime(employeeBean.getInsertTime());
					employeeEntityBean2.setName(employeeBean.getName());
					employeeEntityBean2.setRole(employeeBean.getRole());
					employeeEntityBean2.setSalary(employeeBean.getSalary());
		
					employeeBean2 = convertEntityToBean(employeeEntityBean2);
				entityManager.getTransaction().commit();
			}
		} catch (Exception exception) {
			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		

		return employeeBean2;
	}

	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception{
		// TODO Auto-generated method stub
		EmployeeBean employeeBean = null;
		EntityManager entityManager = null;
		try {
			entityManager =entityManagerFactory.createEntityManager();
			EmployeeEntity employeeEntity = (EmployeeEntity) entityManager.find(EmployeeEntity.class, id);
			if(employeeEntity != null)
			
			{	entityManager.getTransaction().begin();
					entityManager.remove(employeeEntity);
				entityManager.getTransaction().commit();;
				employeeBean =convertEntityToBean(employeeEntity);
			}			

		} catch (Exception exception) {

			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		

		return employeeBean;
	}
	
	
	public List<EmployeeBean> getEmployeeList() throws Exception{
		// TODO Auto-generated method stub
		List<EmployeeBean> listEmployeeBean = null;
		EntityManager entityManager = null;
		try {
			entityManager =entityManagerFactory.createEntityManager();
			listEmployeeBean=new ArrayList<EmployeeBean>();
			List<EmployeeEntity> listEmployeeEntity= (List<EmployeeEntity>) entityManager.createQuery("from EmployeeEntity").getResultList();

			for (EmployeeEntity entity:listEmployeeEntity){
				EmployeeBean emp= convertEntityToBean(entity);
				listEmployeeBean.add(emp);
			}
			

		} catch (Exception exception) {

			throw exception;
		}finally{
			if(entityManager!=null){
				entityManager.close();
			}
		}
		
		//return employeeEntityBean2;
		return (listEmployeeBean);
	}
	
	public static EmployeeBean convertEntityToBean(EmployeeEntity entity){
		EmployeeBean employee = new EmployeeBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}
	public static EmployeeEntity convertBeanToEntity(EmployeeBean bean){
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		BeanUtils.copyProperties(bean,employeeEntity);
		return employeeEntity;
	}
	
	
}
