package com.ares.app.content.vip;
import org.springframework.stereotype.Repository;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;



@Repository
@CollectionName("vipconfig")
public class VipConfigDAO extends MongoDBDAO<VipConfigDO> {


	public VipConfigDAO() {
		super( VipConfigDO.class);
		// TODO Auto-generated constructor stub
	}
}
