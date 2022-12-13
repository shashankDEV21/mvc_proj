package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.CompliantTypeEntity;

@RepositoryDefinition(idClass=Integer.class,domainClass=CompliantTypeEntity.class)
@Transactional(value="txManager")
public interface CompliantTypeDao {

	List<CompliantTypeEntity> findAll();
}
