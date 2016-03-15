package com.ares.app.admincontroller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ares.app.bean.AccountBean;
import com.ares.app.constdata.Const;
import com.ares.app.dao.AccountDAO;
import com.ares.app.domain.Do.AccountDO;

@Controller
public class AccountLoginController {

	@Inject
	private AccountDAO accountDAO;
	
	@RequestMapping(value="/userlogin",method = RequestMethod.POST )
	public ModelAndView  login(AccountBean account,Model model,HttpServletRequest req,HttpServletResponse  response){	
		AccountDO userDO = accountDAO.findById(account.getAccountID());
		if(userDO == null){
			model.addAttribute(Const.ERROR_MSG_TAG, "no this user");
			  return new ModelAndView("login");
		}
		if ( userDO.getPassword().equals(account.getPwd()) ){
			HttpSession session = req.getSession();
			session.setAttribute(Const.ACOUNT_ID, account.getAccountID());
			session.setAttribute(Const.USER_ID, userDO.getUserID());

			RedirectView redirecView = new RedirectView();
			redirecView.setUrl("/view/NoteService/topicList");
			redirecView.setExposePathVariables(true);
			redirecView.setExpandUriTemplateVariables(false);
			redirecView.setExposeModelAttributes(false);
		    return new  ModelAndView(redirecView);
		}
		else {
			model.addAttribute(Const.ERROR_MSG_TAG, " password and account not match");
			return  new ModelAndView("login");
		}
	}
}
