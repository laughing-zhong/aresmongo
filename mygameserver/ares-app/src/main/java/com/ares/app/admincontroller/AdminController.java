package com.ares.app.admincontroller;


import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ares.app.bean.AdminBean;
import com.ares.app.bean.EEAcountBean;
import com.ares.app.dao.AccountDAO;
import com.ares.app.dao.AdminDAO;
import com.ares.app.dao.UserDAO;
import com.ares.app.domain.Do.AccountDO;
import com.ares.app.domain.Do.AdminDO;
import com.ares.app.domain.Do.UserDO;
import com.ares.framework.util.IdUtils;

@Controller
public class AdminController   {	
	
	@Inject
	private  AdminDAO adminDAO;	
	@Inject
	private UserDAO eeUserDAO;
	@Inject
	private AccountDAO accountDAO;
	
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public  String  getAdminList(Model model){			
		List<AdminDO> playerList = 	adminDAO.findAll();
		model.addAttribute("playerList", playerList);
		return "/admin/adduser";	
	}
	
	@RequestMapping(value = "/admin/save/admin",method = RequestMethod.POST)
	public  String  saveAdmin(AdminBean adminBean,Model model){
		AccountDO accountDO = this.accountDAO.findById(adminBean.getName());	
		if(accountDO != null){
			model.addAttribute("errormsg", "user "+adminBean.getName()+" exist");
			return "404";	
		}

		String uid = IdUtils.generate();
		//create account
		accountDO = new AccountDO();
		accountDO.setId(adminBean.getName());
		accountDO.setName(adminBean.getName());
		accountDO.setPassword(adminBean.getPasswd());
		accountDO.setUserID(uid);
		accountDO.setAdmin(true);
		this.accountDAO.create(accountDO);
		
		//create admin 
		AdminDO adminDo = new AdminDO();	
		adminDo.setId(uid);
		adminDo.setName(adminBean.getName());
		adminDo.setEmail(adminBean.getEmail());
		adminDo.setTeleno(adminBean.getTeleno());
	

		adminDAO.upsert(adminDo);	
		return "/admin/adduser";	
	}
	
	@RequestMapping(value="/admin/save/ee_acount",method = RequestMethod.POST)
	public String saveEeAcount(EEAcountBean eeAccountDO){
		AccountDO accountDO = this.accountDAO.findById(eeAccountDO.getName());
		UserDO eeUserDO = new UserDO();
		if(accountDO == null){
			accountDO = new AccountDO();
			accountDO.setId(eeAccountDO.getName());
			accountDO.setName(eeAccountDO.getName());
			accountDO.setPassword(eeAccountDO.getPasswd());
			accountDO.setAdmin(false);
			this.accountDAO.create(accountDO);
			String uid = IdUtils.generate();		
			eeUserDO.setId(uid);		
		}
		eeUserDO.setEmail(eeAccountDO.getEmail());
		eeUserDO.setContactList(eeAccountDO.getContactList());
		eeUserDO.setName(eeAccountDO.getName());
		eeUserDO.setTeleno(eeAccountDO.getTeleno());
	
		boolean ret = eeUserDAO.upsert(eeUserDO);
		if(!ret){
			System.out.println("upsert faild");
		}		
		return "/admin/adduser";
	}
}
