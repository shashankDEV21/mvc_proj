package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.accenture.lkm.entity.EmployeeEntity;



public interface EmployeeDAO extends  CrudRepository<EmployeeEntity, Integer>{
	
	
	@Query("select k from EmployeeEntity k where k.salary >=?1 and k.salary<=?2")
	List<EmployeeEntity> getEmployeeDetailsWithinSalaryRange(double min, double max);
	
}
//Spring JPA DATA 