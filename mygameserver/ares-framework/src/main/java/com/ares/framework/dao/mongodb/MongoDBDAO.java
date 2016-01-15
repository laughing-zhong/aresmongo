package com.ares.framework.dao.mongodb;


import java.io.IOException;
import com.ares.framework.dao.exception.DAOException;
import com.ares.framework.dao.json.transcoder.JsonObjectMapper;
import com.ares.framework.domain.MongoKeyDO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class MongoDBDAO <DomainObject extends MongoKeyDO> extends AbstractMongodbDAO<DomainObject>  {
 
	
	private Class<DomainObject>  domainObjectClass ;
	
	public MongoDBDAO( Class<DomainObject>  domainObjectClass){
		this.domainObjectClass = domainObjectClass;
	}

	@Override
	public DomainObject findById(String targetId) throws DAOException {
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
	public DomainObject findById(String... targetIds) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


}
