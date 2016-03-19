package com.ares.app.domain.Do;

import com.ares.framework.domain.MongoKeyDO;

public class NoteCatagoryDO  extends MongoKeyDO{
	private String id;
	private String topic;
	private String sender;
	private String topicId;
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
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
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	private String sendTime;
	private String lastRplTime;
	public String getLastRplTime() {
		return lastRplTime;
	}
	public void setLastRplTime(String lastRplTime) {
		this.lastRplTime = lastRplTime;
	}

}
