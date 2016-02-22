package com.ares.app.admincontroller;


import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ares.app.domain.Do.AdminDO;



@Controller
public class AdminService   {	
	@RequestMapping(value = "/admin",method=RequestMethod.GET)
	public  String  getAdminList(Model model){
		
		List<AdminDO> playerList = new ArrayList<AdminDO>();
		for( int i = 0 ; i < 5; ++i){
			AdminDO player = new AdminDO();
			player.setId(i+"");
			player.setName("name"+i);
			playerList.add(player);
		}
		model.addAttribute("playerList", playerList);
		return "/admin/adduser";	
	}
	
	@RequestMapping(value = "/admin/save/admin",method=RequestMethod.POST)
	public  String  saveAdmin(AdminDO AdminDO,Model model){
		
		List<AdminDO> playerList = new ArrayList<AdminDO>();
		for( int i = 0 ; i < 5; ++i){
			AdminDO player = new AdminDO();
			player.setId(i+"");
			player.setName("name"+i);
			playerList.add(player);
		}
		model.addAttribute("playerList", playerList);
		return "/admin/adduser";	
	}
	
}
