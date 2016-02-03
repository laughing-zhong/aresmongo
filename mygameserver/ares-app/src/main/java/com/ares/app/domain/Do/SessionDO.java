package com.ares.app.domain.Do;

import java.util.Date;

import com.ares.framework.domain.MongoKeyDO;

public class SessionDO  extends MongoKeyDO{
	
	private String sessionId;
	private String componayId;

	public String getComponayId() {
		return componayId;
	}
	public void setComponayId(String componayId) {
		this.componayId = componayId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Date getLstOptDate() {
		return lstOptDate;
	}
	public void setLstOptDate(Date lstOptDate) {
		this.lstOptDate = lstOptDate;
	}
	private Date  lstOptDate;

}
