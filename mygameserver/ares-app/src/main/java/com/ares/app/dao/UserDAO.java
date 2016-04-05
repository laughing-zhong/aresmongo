package com.ares.app.dao;
import org.springframework.stereotype.Repository;



import com.ares.app.domain.Do.UserDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;


@Repository
@CollectionName("ee_account")
public class UserDAO extends MongoDBDAO<UserDO>{
	
	public UserDAO(){
		super(UserDO.class);
	}
}
