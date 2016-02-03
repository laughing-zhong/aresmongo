package com.ares.app.domain.Do;

import com.ares.framework.domain.MongoKeyDO;

public class AccountDO extends MongoKeyDO {
	
	public AccountDO(){}
	private String userName;
	private String pwd;
	

	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

