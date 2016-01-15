package com.ares.framework.dao.mongodb;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.ares.framework.dao.exception.DAOException;
import com.ares.framework.dao.json.transcoder.JsonObjectMapper;
import com.ares.framework.dao.mongodb.client.SynMongClient;
import com.ares.framework.domain.MongoKeyDO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class MongoDBDAO <DomainDO extends MongoKeyDO> extends AbstractMongodbDAO<DomainDO>  {
 
	
	private Class<DomainDO>  domainObjectClass ;
	
	public MongoDBDAO( Class<DomainDO>  domainObjectClass){
		this.domainObjectClass = domainObjectClass;
	}

	@Override
	public DomainDO findById(String targetId) throws DAOException {
		// TODO Auto-generated method stub	
		//String jsonStr = JsonUtil.genJsonStr(jsonObj);
		try {
			return  JsonObjectMapper.getInstance().readValue("  ", domainObjectClass);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<DomainDO> findById(String... targetIds) throws DAOException {
		return findByIds(Arrays.asList(targetIds));
	}
	
	private DomainDO ducument2DomainDO(Document document){
		try {
			return JsonObjectMapper.getInstance().readValue(document.getString(SynMongClient.MONGOID),domainObjectClass);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DomainDO> findByIds(List<String> ids) throws DAOException {
	    List<Document> documents = this.mgDataSource.getMgConnection().findObjList(this.collectionName, SynMongClient.MONGOID, ids);
	  List<DomainDO> domainDoList = new ArrayList<DomainDO>();
	    for(Document document :documents){    	
	    	domainDoList.add(this.ducument2DomainDO(document));
	    }
		return domainDoList;
	}
}
