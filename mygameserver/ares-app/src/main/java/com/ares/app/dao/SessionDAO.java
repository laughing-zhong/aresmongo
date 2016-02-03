package com.ares.app.dao;

import org.springframework.stereotype.Repository;


import com.ares.app.domain.Do.SessionDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;

@Repository
@CollectionName("session")
public class SessionDAO extends MongoDBDAO<SessionDO>{

	public SessionDAO() {
		super(SessionDO.class);
		// TODO Auto-generated constructor stub
	}
}
