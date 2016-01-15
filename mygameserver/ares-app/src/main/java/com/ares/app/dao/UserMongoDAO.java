package com.ares.app.dao;



import org.springframework.stereotype.Repository;

import com.ares.app.domain.Do.UserCbDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;




@Repository
@CollectionName("user")

public class UserMongoDAO extends MongoDBDAO<UserCbDO>{
	
	public UserMongoDAO(){
		super(UserCbDO.class);
	}

}
