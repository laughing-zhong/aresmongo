package com.ares.app.dao;



import org.springframework.stereotype.Repository;

import com.ares.app.domain.Do.UserMongoDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;




@Repository
@CollectionName("gameplayer")
public class UserMongoDAO extends MongoDBDAO<UserMongoDO>{
	
	public UserMongoDAO(){
		super(UserMongoDO.class);
	}

}
