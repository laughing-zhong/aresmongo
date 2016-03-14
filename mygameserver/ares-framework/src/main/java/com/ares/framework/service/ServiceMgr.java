package com.ares.framework.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Component;


@Component
public class ServiceMgr {

   @Inject
   private List<RpcService> rpcServices;
   	
	@PostConstruct
	public void Init()
	{
		for(RpcService service : rpcServices){
			String serviceName = service.getClass().getSimpleName();
			serviceMaps.put(serviceName, service);
		}
	}
	
	
  public RpcService  GetService(String serviceName){
	  return serviceMaps.get(serviceName);
  }
    
	private   Map<String,RpcService>   serviceMaps = new HashMap<>();

}
