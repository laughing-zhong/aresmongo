package com.ares.framework.dao.mongodb;

import java.util.List;






import javax.inject.Inject;

import org.bson.Document;

import com.ares.framework.dao.exception.DAOException;
import com.ares.framework.dao.exception.KeyNotFoundException;
import com.ares.framework.dao.mongo.IDAO;
import com.ares.framework.dao.mongodb.client.MgDataSource;
import com.ares.framework.dao.mongodb.client.SynMongClient;
import com.ares.framework.domain.MongoKeyDO;
import com.ares.framework.exception.DocumentIdEmptyException;
import com.ares.framework.util.IdUtils;
import com.ares.framework.util.JsonUtil;
import com.google.common.base.Strings;

public abstract class AbstractMongodbDAO <DomainDO extends MongoKeyDO>  implements IDAO<DomainDO>  {

	
	private final static String DATA="d";
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
		if(Strings.isNullOrEmpty(objectToPersist.getId())){
			throw new DocumentIdEmptyException("document id should not null");
		}
		String jsonString = JsonUtil.genJsonStr(objectToPersist);
		Document document = new Document(SynMongClient.MONGOID,objectToPersist.getId()).append(DATA, jsonString);
		mgDataSource.getMgConnection().insert(this.collectionName, document);
		
	}

	@Override
	public void replace(DomainDO objectToPersist) throws KeyNotFoundException,
			DAOException {
		  Document document = new Document(SynMongClient.MONGOID,objectToPersist.getId()).append(DATA, JsonUtil.genJsonStr(objectToPersist));
		  this.mgDataSource.getMgConnection().update(this.collectionName, document);
		
	}

	@Override
	public void put(DomainDO objectToPersist) throws DAOException {
		create(objectToPersist);
			
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
