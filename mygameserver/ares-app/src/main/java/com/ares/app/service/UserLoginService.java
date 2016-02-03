package com.ares.app.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ares.app.DO.User;
import com.ares.app.dao.AccountDAO;
import com.ares.app.domain.Do.AccountDO;
import com.ares.framework.service.IService;

@Component
public class UserLoginService  implements IService{
	
	@Inject 
	private AccountDAO userDAO;
	public String  login(User user,Model model){
		
		AccountDO userDo = new AccountDO();
		userDo.setId(user.getId());
		userDo.setUserName(user.getUserName());		
		userDAO.create(userDo);
		return "courseList";
		
	}

}
