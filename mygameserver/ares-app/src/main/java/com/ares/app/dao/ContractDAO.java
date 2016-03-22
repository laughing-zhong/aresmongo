package com.ares.app.dao;

import org.springframework.stereotype.Repository;
import com.ares.app.domain.Do.ContractDO;
import com.ares.framework.dao.mongodb.CollectionName;
import com.ares.framework.dao.mongodb.MongoDBDAO;

@Repository
@CollectionName("contracts")
public class ContractDAO  extends MongoDBDAO<ContractDO> {

	public ContractDAO() {
		super(ContractDO.class);
	}
}
