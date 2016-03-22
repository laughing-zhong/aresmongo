package com.ares.app.domain.Do;

import org.joda.time.DateTime;

import com.ares.framework.domain.MongoKeyDO;

public class ContractDO extends MongoKeyDO{
	private String company;
	private DateTime   beginTime;
	private String contactUser;
	public String getContactUser() {
		return contactUser;
	}
	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public DateTime getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(DateTime beginTime) {
		this.beginTime = beginTime;
	}
	public DateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}
	private DateTime  endTime;

}
