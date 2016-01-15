package com.ares.framework.dao.mongodb;

import java.util.List;






import javax.inject.Inject;

import com.ares.framework.dao.exception.DAOException;
import com.ares.framework.dao.exception.KeyNotFoundException;
import com.ares.framework.dao.mongo.IDAO;
import com.ares.framework.dao.mongodb.client.MgDataSource;
import com.ares.framework.domain.MongoKeyDO;
import com.google.common.base.Strings;

public abstract class AbstractMongodbDAO <DomainDO extends MongoKeyDO>  implements IDAO<DomainDO>  {

	
	@Inject
	protected MgDataSource  mgDataSource;
	
	@Override
	public void onFError(String targetId) {
		// TODO Auto-generated method stub
		
	}
	
	public AbstractMongodbDAO(){
		this.collectionName = this.getCollectionName();
	}

	@Override
	public void create(DomainDO objectToPersist) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replace(DomainDO objectToPersist) throws KeyNotFoundException,
			DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void put(DomainDO objectToPersist) throws DAOException {
		// TODO Auto-generated method stub
			
	}




	@Override
	public List<DomainDO> findByIds(List<String> ids) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(DomainDO targetObject) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(String targetId) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	
	protected String collectionName;
	
	protected String getCollectionName(){
		CollectionName coll= getClass().getAnnotation(CollectionName.class);
		if(coll == null || Strings.isNullOrEmpty(coll.value())){
	        System.out.println("=======  this collection name is null?? should add CollectionName ");
			return this.getClass().getSimpleName();
		}
		return coll.value();	
	}

}
