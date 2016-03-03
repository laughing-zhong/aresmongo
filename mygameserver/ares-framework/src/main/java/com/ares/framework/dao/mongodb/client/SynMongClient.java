package com.ares.framework.dao.mongodb.client;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;



import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public class SynMongClient implements IMongodbClient{


	public final static String MONGOID = "_id";
	public final static String MONGDATA = "d";
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> findObjList(String clltName, String filedName,List<String> uIds) {
//		return  db.getCollection(clltName)
//				.find(Filters.in(filedName,uIds.iterator()))
//				.into(new ArrayList<Document>());
		db.getCollection(clltName).find(Filters.in(filedName, uIds.iterator())).into(new ArrayList<Document>());
		return null;
		//return db.getCollection(clltName).find().into(new ArrayList<Document>());
	}

	@Override
	public List<Document> findObjListBetween(String clltName, String filedName,
			int low, int high) {
		return db.getCollection(clltName)
				.find(Filters.and(Filters.lt(filedName, high),Filters.gt(filedName, low)))
				.into(new ArrayList<Document>());
	}

	@Override
	public List<Document> findObjListLarger(String clltName, String filedName,
			int targetCount) {
		return db.getCollection(clltName).find(Filters.gt(filedName, targetCount))
				.into(new ArrayList<Document>());
	}

	@Override
	public List<Document> findObjListBelower(String clltName, String filedName,
			int targetCount) {
		return db.getCollection(clltName).find(Filters.lt(filedName, targetCount))
				.into(new ArrayList<Document>());
	}

	@Override
	public List<Document> findObjListByFileter(String clltName, Bson filter) {
		return db.getCollection(clltName).find(filter).into(new ArrayList<Document>());				
	}
	@Override
	public void delete(String clltName,String targetId) {
		// TODO Auto-generated method stub
		 db.getCollection(clltName).deleteOne(Filters.eq(MONGOID, targetId));	
	}
	@Override
	public List<String> getDbs() {
		// TODO Auto-generated method stub
	 List<String> names = new ArrayList<String>();
	  MongoCursor<String> it = mongoClient.listDatabaseNames().iterator();
		while(it.hasNext()){
			names.add(it.next());
		}
		return names ;
	}
	@Override
	public List<String> getCollections(String dbName) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
	    MongoCursor<String> it = this.mongoClient.getDatabase(dbName).listCollectionNames().iterator();
	    while(it.hasNext()){
	    	names.add(it.next());
	    }	
		return names;
	}
	
	@Override
	public List<Document>findAll(String clltName){		
		 return  db.getCollection(clltName).find().into(new ArrayList<Document>());
	}

}
