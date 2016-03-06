package com.ares.app.bean;

import java.util.List;

public class EEAcountBean {

	
	public EEAcountBean(){}
	private String name;
	private String passwd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
