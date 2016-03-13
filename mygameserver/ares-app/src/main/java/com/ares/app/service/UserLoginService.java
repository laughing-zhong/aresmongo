package com.ares.app.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ares.app.bean.AccountBean;
import com.ares.app.dao.AccountDAO;
import com.ares.app.domain.Do.AccountDO;
import com.ares.framework.service.IService;

@Component
public class UserLoginService  implements IService{
	@Inject
	private AccountDAO accountDAO;
	public String  login(AccountBean account,Model model){
		AccountDO userDO = accountDAO.findById(account.getAccountID());
		if(userDO == null){
			model.addAttribute("errormsg", "login faild");
			return "404";
		}
		if ( userDO.getPassword().equals(account.getPwd()) )
		   return "default";	
		else {
			model.addAttribute("errormsg", "id and password not match");
			return "404";
		}
	}
}
