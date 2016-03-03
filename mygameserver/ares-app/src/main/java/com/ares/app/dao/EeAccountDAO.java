package com.ares.app.dao;
import org.springframework.stereotype.Repository;



import com.ares.app.domain.Do.EeAccountDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;


@Repository
@CollectionName("ee_account")
public class EeAccountDAO extends MongoDBDAO<EeAccountDO>{
	
	public EeAccountDAO(){
		super(EeAccountDO.class);
	}
}
