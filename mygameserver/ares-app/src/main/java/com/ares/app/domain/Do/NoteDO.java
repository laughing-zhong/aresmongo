package com.ares.app.domain.Do;

import java.util.ArrayList;
import java.util.List;

import com.ares.framework.domain.MongoKeyDO;

public class NoteDO  extends MongoKeyDO {
	public NoteDO(){}
	private String title;
	private String content;
	private int type;
	private String catagoryId;
	public String getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(String catagoryId) {
		this.catagoryId = catagoryId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	private List<SubNote> subNoteList ;
	
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
