package com.ares.app.domain.Do;

import com.ares.framework.domain.MongoKeyDO;

public class NoteCatagoryDO  extends MongoKeyDO{
	private String id;
	private String topic;
	private String sender;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getSendTimer() {
		return sendTimer;
	}
	public void setSendTimer(String sendTimer) {
		this.sendTimer = sendTimer;
	}
	private String sendTimer;

}
