package com.ares.framework.dao.mongodb.client;

public class MgDataSource {
	private IMongodbClient mongodbClient;
	
	public MgDataSource(IMongodbClient  mongodbClient){
		this.mongodbClient = mongodbClient;
	}
	
	public IMongodbClient  getMgConnection(){		
		return this.mongodbClient;
	}

}
