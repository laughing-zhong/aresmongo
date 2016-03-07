package com.ares.app.domain.Do;


import java.util.List;

import com.ares.framework.domain.MongoKeyDO;

public class AdminDO extends MongoKeyDO{
	private String  email;

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
	private String teleno;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	private List<String>employeeList;
	private List<String>managerList ;
	public List<String> getManagerList() {
		return managerList;
	}
	public void setManagerList(List<String> managerList) {
		this.managerList = managerList;
	}
	public List<String> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<String> employeeList) {
		this.employeeList = employeeList;
	}
}
