package com.ares.framework.dao.mongodb.client;

import java.util.List;

import org.bson.BsonValue;
import org.bson.Document;
import org.bson.conversions.Bson;

public interface IMongodbClient {
	
	public Document findById(String cllctName,String uId);
	public boolean  update(String clltName,Document document);
	public void     insert(String clltName,Document document);
	public boolean  upsert(String clltName,Document document);
	public boolean  delete(String clltName,String targetId);
	
	List<String> getDbs();
	List<String> getCollections(String db);

	public List<Document> findObjList(String clltName,String filedName,List<String>uIds);
	public List<Document> findObjList(String clltName,String filedName,String ... uIds);; 
	public List<Document> findObjListBetween(String clltName,String filedName,int low,int high);
	public List<Document> findObjListLarger(String clltName,String filedName,int targetCount);
	public List<Document> findObjListBelower(String clltName,String filedName,int targetCount);
	public List<Document> findObjListByFileter(String clltName,Bson filter);
	public List<Document> findAll(String clltName);

}
