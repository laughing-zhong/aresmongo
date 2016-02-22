package com.ares.app.admincontroller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AdminService   {
	
	
	@RequestMapping(value = "/admin",method=RequestMethod.GET)
	public  String  getAdminList(Model model){
		
		List<AdminPlayer> playerList = new ArrayList<AdminPlayer>();
		for( int i = 0 ; i < 5; ++i){
			AdminPlayer player = new AdminPlayer();
			player.setId(i+"");
			player.setName("name"+i);
			playerList.add(player);
		}
		model.addAttribute("playerList", playerList);
		return "/admin/adduser";	
	}
	
	@RequestMapping(value = "/admin/save/admin",method=RequestMethod.POST)
	public  String  saveAdmin(AdminPlayer adminPlayer,Model model){
		
		List<AdminPlayer> playerList = new ArrayList<AdminPlayer>();
		for( int i = 0 ; i < 5; ++i){
			AdminPlayer player = new AdminPlayer();
			player.setId(i+"");
			player.setName("name"+i);
			playerList.add(player);
		}
		model.addAttribute("playerList", playerList);
		return "/admin/adduser";	
	}
	
	
	
	
	public static class AdminPlayer{
		private String id;
		private String  email;
		private String passwd;
		public String getPasswd() {
			return passwd;
		}
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTeleno() {
			return teleno;
		}
		public void setTeleno(String teleno) {
			this.teleno = teleno;
		}
		private String teleno;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		private String name;
	}
	

}
