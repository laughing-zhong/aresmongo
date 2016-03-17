package com.ares.app.domain.Do;

import java.util.List;


import com.ares.framework.domain.MongoKeyDO;

public class NoteDO  extends MongoKeyDO {
	public NoteDO(){}
	private String topic;
	private String content;
	private int type;
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendUserName() {
		return sendUserName;
	}
	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	private String sendUserName;
	private String sendTime;
	private List<SubNote> subNoteList;
	
	public List<SubNote> getSubNoteList() {
		return subNoteList;
	}
	public void setSubNoteList(List<SubNote> subNoteList) {
		this.subNoteList = subNoteList;
	}

	public static class SubNote{
		public SubNote(){}
		private String sendName;
		public String getSendName() {
			return sendName;
		}
		public void setSendName(String sendName) {
			this.sendName = sendName;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		private String content;
	}
}
