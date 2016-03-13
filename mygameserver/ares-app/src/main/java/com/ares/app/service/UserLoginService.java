package com.ares.app.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ares.app.bean.AccountBean;
import com.ares.app.dao.EeUserDAO;
import com.ares.app.domain.Do.EeUserDO;
import com.ares.framework.service.IService;

@Component
public class UserLoginService  implements IService{
	
	@Inject 
	private EeUserDAO userDAO;
	public String  login(AccountBean account,Model model){
		EeUserDO userDO = userDAO.findById(account.getAccountID());
		if(userDO == null){
			model.addAttribute("errormsg", "login faild");
			return "404";
		}
		return "defalut";		
	}

}
