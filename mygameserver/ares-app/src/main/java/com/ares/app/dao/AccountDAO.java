package com.ares.app.dao;

import org.springframework.stereotype.Repository;

import com.ares.app.domain.Do.AccountDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;

@Repository
@CollectionName("admin")
public class AccountDAO extends MongoDBDAO<AccountDO>{

	public AccountDAO() {
		super(AccountDO.class);
		// TODO Auto-generated constructor stub
	}

}
