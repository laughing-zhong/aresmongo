package com.ares.app.dao;

import org.springframework.stereotype.Repository;

import com.ares.app.domain.Do.RoleDO;

import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;


@Repository
@CollectionName("role")
public class RoleDAO extends MongoDBDAO<RoleDO>{
	public RoleDAO(){
		super(RoleDO.class);
	}
}
