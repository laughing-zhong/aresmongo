package com.ares.app.service.mongutls;

import javax.inject.Inject;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.ares.app.bean.LookupBean;
import com.ares.app.bean.WirteMongbdBean;
import com.ares.framework.dao.mongodb.client.MgDataSource;
import com.ares.framework.dao.mongodb.client.SynMongClient;
import com.ares.framework.service.IService;

@Component
public class MongdbUtilsService  implements IService{
	
	private final static String DATA="d";
	@Inject
	protected MgDataSource  mgDataSource;
	public Document  wirteMgContent(WirteMongbdBean content){
		
		Document doc = this.mgDataSource.getMgConnection().findById(content.getTableName(), content.getDocId());
		if( doc == null){
			 doc = new Document("_id",content.getDocId()).append(DATA, content.getContent());
			this.mgDataSource.getMgConnection().insert(content.getTableName(),doc);
			return doc;
		}
		Document document = new Document(SynMongClient.MONGOID,content.getDocId()).append(DATA, content.getContent());
		this.mgDataSource.getMgConnection().update(content.getTableName(), document);		
		return document;		
	}
	
	public Document lookup(LookupBean lookUp){
		
		return this.mgDataSource.getMgConnection().findById(lookUp.getTableName(), lookUp.getDocId());
	}

}
