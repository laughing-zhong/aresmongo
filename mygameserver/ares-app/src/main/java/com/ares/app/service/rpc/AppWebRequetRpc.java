package com.ares.app.service.rpc;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.ares.app.constdata.Const;
import com.ares.framework.rpc.WebRequestRpc;
import com.ares.framework.rpc.context.RpcContext;
import com.ares.service.exception.RunLogicException;


@Controller
public class AppWebRequetRpc  extends WebRequestRpc{

	@Inject
	private Provider<RpcContext> contextProvider;
	
	
	@Override
	public void checkSession(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if(session == null){
			throw  new RunLogicException("please login first", "login");
		}
		RpcContext context = contextProvider.get();
		context.setAccountID((String)session.getAttribute(Const.ACOUNT_ID));
		context.setUserID((String)session.getAttribute(Const.USER_ID));			
	}

	@Override
	public void postProcess() {
		// TODO Auto-generated method stub
		
	}

}
