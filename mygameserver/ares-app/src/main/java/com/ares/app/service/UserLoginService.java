package com.ares.app.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ares.app.DO.User;
import com.ares.app.dao.EeAccountDAO;
import com.ares.app.domain.Do.EeAccountDO;
import com.ares.framework.service.IService;

@Component
public class UserLoginService  implements IService{
	
	@Inject 
	private EeAccountDAO userDAO;
	public String  login(User user,Model model){
		
		EeAccountDO userDo = new EeAccountDO();
		userDo.setId(user.getId());
		userDo.setName(user.getUserName());		
		userDAO.create(userDo);
		return "courseList";
		
	}

}
