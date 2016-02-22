package com.ares.app.dao;

import org.springframework.stereotype.Repository;

import com.ares.app.domain.Do.AccountDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;


@Repository
@CollectionName("account")
public class AdminDAO extends MongoDBDAO<AccountDO>{

	public AdminDAO() {
		super(AccountDO.class);
	}

}
