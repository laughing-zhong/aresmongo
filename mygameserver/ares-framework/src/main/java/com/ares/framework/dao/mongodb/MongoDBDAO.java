package com.ares.framework.dao.mongodb;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.BsonArray;
import org.bson.BsonString;
import org.bson.BsonValue;
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
		Document document = mgDataSource.getMgConnection().findById(this.getCollectionName(), targetId);
	    if(document == null) return null;
		try {
			return  JsonObjectMapper.getInstance().readValue(document.getString("d"), domainObjectClass);
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
			System.out.println("document = "+document);
			return JsonObjectMapper.getInstance().readValue(document.getString(SynMongClient.MONGDATA),domainObjectClass);
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
	
	@Override 
	public List<DomainDO> findAll() throws DAOException{
		List<Document> docList = this.mgDataSource.getMgConnection().findAll(this.collectionName);
		List<DomainDO> domainList = new ArrayList<DomainDO>();
		for(Document doc : docList){
			domainList.add(this.ducument2DomainDO(doc));
		}
		return domainList;		
	}
	
	@Override
	public List<DomainDO> findDocs(String filedName,List<String> targetIds){
		
//		List<BsonValue> targetIdList = new BsonArray();
//		for( int i = 0 ; i <  targetIds.size(); ++i){
//			BsonString bs = new BsonString (targetIds.get(i));
//			targetIdList.add(bs);
//		}

		List<Document> docList= 	this.mgDataSource.getMgConnection().findObjList(this.collectionName, filedName, targetIds);
		List<DomainDO> domainList = new ArrayList<DomainDO>();
		for(Document doc : docList){
			domainList.add(this.ducument2DomainDO(doc));
		}
		return domainList;	
	}
	
	@Override
	public 	List<DomainDO> findDos(String filedName,String ... targetIds){		
		List<Document> docList = this.mgDataSource.getMgConnection().findObjList(this.collectionName, filedName,targetIds);
		List<DomainDO> domainList = new ArrayList<DomainDO>();
		for(Document doc : docList){
			domainList.add(this.ducument2DomainDO(doc));
		}
		return domainList;			
	}

	@Override
	public long getCount() {
		// TODO Auto-generated method stub
		return  this.mgDataSource.getMgConnection().getCount(this.collectionName);
	}	
}
