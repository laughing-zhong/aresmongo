package com.ares.app.dao;

import org.springframework.stereotype.Repository;

import com.ares.app.domain.Do.NoteCatagoryDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;

@Repository
@CollectionName("notecatagory")
public class NoteCatagoryDAO extends MongoDBDAO<NoteCatagoryDO>{

	public NoteCatagoryDAO() {
		super(NoteCatagoryDO.class);
	}
}
