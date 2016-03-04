package com.ares.app.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.ares.app.dao.EeAccountDAO;
import com.ares.app.domain.Do.EeAccountDO;
import com.ares.framework.service.IService;

@Component
public class EeAcountService implements IService{
	
	@Inject
	private EeAccountDAO eeAccountDAO;
	
	public EeAccountDO  searchEeAccount(String accountName){		
		List<EeAccountDO> eeAccountList = eeAccountDAO.findDos("_id", accountName);
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
