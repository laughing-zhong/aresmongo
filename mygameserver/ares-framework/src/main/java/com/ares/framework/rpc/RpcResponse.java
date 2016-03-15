package com.ares.framework.rpc;

public class RpcResponse {
	public String WebPage;
	public String Method;
	public String Service;
	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(WebPage != null){
			sb.append(WebPage);
		}
		if(Service != null){
			sb.append("/");
			sb.append(Service);
		}
		if(Method != null){
			sb.append("/");
			sb.append(Method);
		}
		return sb.toString();			
	}

}
