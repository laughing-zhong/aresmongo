package com.ares.app.service;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ares.app.DO.User;
import com.ares.framework.service.IService;

@Component
public class UserLoginService  implements IService{
	
	public String  login(User user,Model model){
		
		return "courseList";
		
	}

}
