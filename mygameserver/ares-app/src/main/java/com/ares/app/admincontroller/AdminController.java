package com.ares.app.admincontroller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ares.app.dao.AdminDAO;
import com.ares.app.dao.EeAccountDAO;
import com.ares.app.domain.Do.AdminDO;
import com.ares.app.domain.Do.EeAccountDO;
import com.ares.app.service.exception.DataException;
import com.ares.framework.util.IdUtils;



@Controller
public class AdminController   {	
	
	@Inject
	private  AdminDAO adminDAO;	
	@Inject
	private EeAccountDAO eeAccountDAO;
	
	@RequestMapping(value = "/admin",method=RequestMethod.GET)
	public  String  getAdminList(Model model){			
		List<AdminDO> playerList = 	adminDAO.findAll();
		model.addAttribute("playerList", playerList);
		return "/admin/adduser";	
	}
	
	@RequestMapping(value = "/admin/save/admin",method=RequestMethod.POST)
	public  String  saveAdmin(AdminDO adminDO,Model model){	
		if(adminDO.getId() == null){
			adminDO.setId(IdUtils.generate());
		}
		adminDAO.create(adminDO);	
		return "/admin/adduser";	
	}
	
	@RequestMapping(value="/admin/save/ee_acount",method = RequestMethod.POST)
	public String saveEeAcount(EeAccountDO eeAccountDO){		
		if(eeAccountDO.getId() == null){
			eeAccountDO.setId(eeAccountDO.getName());
		}
		boolean ret = eeAccountDAO.upsert(eeAccountDO);
		if(!ret){
			System.out.println("upsert faild");
		}		
		return "/admin/adduser";
	}
	
	
}
