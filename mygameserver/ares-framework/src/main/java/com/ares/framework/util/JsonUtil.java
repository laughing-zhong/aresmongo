package com.ares.framework.util;

import com.ares.framework.dao.json.transcoder.JsonObjectMapper;
import com.ares.framework.domain.MongoKeyDO;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JsonUtil {
	public static String  genJsonStr(MongoKeyDO jsonDo){
		
		try {
			return JsonObjectMapper.getInstance().writeValueAsString(jsonDo);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
