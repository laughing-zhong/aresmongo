package com.ares.app.dao;
import org.springframework.stereotype.Repository;



import com.ares.app.domain.Do.EeUserDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;


@Repository
@CollectionName("ee_account")
public class EeUserDAO extends MongoDBDAO<EeUserDO>{
	
	public EeUserDAO(){
		super(EeUserDO.class);
	}
}
