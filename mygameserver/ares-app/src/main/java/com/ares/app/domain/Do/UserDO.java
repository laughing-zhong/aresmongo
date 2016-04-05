package com.ares.app.domain.Do;

import java.util.List;

import com.ares.framework.domain.MongoKeyDO;

public class UserDO extends MongoKeyDO {
	
	public UserDO(){}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	private String email;
	private String teleno;
	
	
	List<String> contactList ;


	public List<String> getContactList() {
		return contactList;
	}
	public void setContactList(List<String> contactList) {
		this.contactList = contactList;
	}
}

