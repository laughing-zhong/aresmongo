package com.ares.framework.rpc.filter;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ares.framework.rpc.context.RpcContext;


public class SessionInterceptor implements HandlerInterceptor {

	@Inject
	private Provider<RpcContext> rpcContextProvider;
	
	@Override
	public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1,
			Object o) throws Exception {
		// User user=(User) hsr.getSession().getAttribute("LoginUser");
		// if(user==null){
		// logger.log(Level.INFO, "user not login");
		// hsr1.sendRedirect("/SundearEmm");
		// return false;
		// }
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
	   this.rpcContextProvider.get().setPlayerID("111");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1,
			Object o, ModelAndView mav) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest hsr,
			HttpServletResponse hsr1, Object o, Exception excptn)
			throws Exception {
	}
}