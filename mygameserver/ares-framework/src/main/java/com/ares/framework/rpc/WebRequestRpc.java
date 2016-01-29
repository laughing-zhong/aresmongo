package com.ares.framework.rpc;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ares.framework.rpc.json.JsonResponse;
import com.ares.framework.rpc.json.MsgState;
import com.ares.framework.service.IService;
import com.ares.framework.service.JIService;
import com.ares.framework.service.ServiceMgr;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;



@Controller
@RequestMapping(value="/rpc/{serviceName}/{methodName}" )
public class WebRequestRpc {
	@Inject
	private ServiceMgr  serviceMgr;
	
	public WebRequestRpc()
	{
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String  JCallRpc(@PathVariable String serviceName,
			@PathVariable String  methodName,Model model,HttpServletRequest req ) throws JsonParseException, JsonMappingException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, InstantiationException
	{
		IService service = serviceMgr.GetService(serviceName);
		if(service == null)
		{
			model.addAttribute("errormsg", "can not find the service name :"+serviceName);
		    return "404";
		}
		
		Method method = this.GetMethod(service, methodName);
		if(method == null)
		{
			model.addAttribute("errormsg", "can not find the method:"+methodName+"in the service: "+serviceName);
			 return "404";
		}
		return  CallObMethod(service, method, req.getParameterMap(),model);
	}
	
	private Method GetMethod(Object obj, String methodName)
	{
		Method[] methods = obj.getClass().getMethods();
		for(int i = 0 ; i < methods.length ; ++i)
		{
			if(methods[i].getName().equals(methodName))
			{
				return methods[i];
			}
		}
		return null;
	}
	
	private  String CallObMethod(IService service, Method method, Map<String,String[]> params,Model model) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, JsonParseException, JsonMappingException, IOException, InstantiationException
	{
		 Class<?> methosParamType = method.getParameterTypes()[0];  
		 
		  Object obj = methosParamType.newInstance();
	       try {
				BeanUtils.populate(obj, params);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	   return  (String)method.invoke(service, obj,model);        
	}
}
