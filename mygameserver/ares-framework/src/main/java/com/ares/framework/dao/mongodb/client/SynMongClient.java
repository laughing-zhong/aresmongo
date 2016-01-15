package com.ares.framework.dao.mongodb.client;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public class SynMongClient implements IMongodbClient{


	private final static String MONGOID="_id";
	private  MongoClient mongoClient;
	private  MongoDatabase db ;
	public SynMongClient(MongdbConfigBean  configBean){	
         mongoClient = new MongoClient(configBean.getAddr(),configBean.getPort());
         db = mongoClient.getDatabase(configBean.getDbName());	
	}
	@Override
	public Document findById(String cllctName, String uId) {
	  FindIterable<Document>  iter = db.getCollection(cllctName).find(Filters.eq(MONGOID, uId));
	  return iter.first();
	}
	
	@Override
	public void  insert(String clltName,Document document){
		db.getCollection(clltName).insertOne(document);
	}

	@Override
	public void update(String clltName, Document document) {
		db.getCollection(clltName).replaceOne(Filters.eq(MONGOID, document.get(MONGOID)), document);
		
	}

	@Override
	public List<Document> findObjList(String clltName, String filedName,List<String> uIds) {
		return  db.getCollection(clltName).find(Filters.in("", filedName,uIds.iterator())).into(new ArrayList<Document>());
	}

	@Override
	public List<Document> findObjListBetween(String clltName, String filedName,
			int low, int high) {
		//db.getCollection(clltName).find(Filters.and(Filters.lt(fieldName, high))(fieldName, geometry), resultClass)
		return null;
	}

	@Override
	public List<Document> findObjListLarger(String clltName, String filedName,
			int targetCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> findObjListBelower(String clltName, String filedName,
			int targetCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> findObjListByFileter(String clltName, Bson filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
