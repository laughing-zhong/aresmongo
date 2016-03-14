package com.ares.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.ares.app.dao.EeUserDAO;
import com.ares.app.domain.Do.EeUserDO;
import com.ares.framework.service.RpcService;

@Component
public class EeAcountService implements RpcService{
	
	@Inject
	private EeUserDAO eeAccountDAO;
	
	public EeUserDO  searchEeAccount(String accountName){		
		List<EeUserDO> eeAccountList = eeAccountDAO.findDos("_id", accountName);
		int count = eeAccountList.size();
		if(count > 1){
			System.out.println(" select userName  "+accountName+" count = "+count);
		}
		if(count == 1){
			return eeAccountList.get(0);
		}
		return null;
	}

}
