package com.ares.app.bean;

public class TopicCategoryBean {
	private String id;
	private String lastRplTime;
	public String getLastRplTime() {
		return lastRplTime;
	}
	public void setLastRplTime(String lastRplTime) {
		this.lastRplTime = lastRplTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	enum TopicType{
		NORMAL,
		TOP,
		Essence
	}
	private String topic;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderTime() {
		return senderTime;
	}
	public void setSenderTime(String senderTime) {
		this.senderTime = senderTime;
	}
	public TopicType getType() {
		return type;
	}
	public void setType(TopicType type) {
		this.type = type;
	}
	private String senderName;
	private String senderTime;
	private TopicType type;

}
