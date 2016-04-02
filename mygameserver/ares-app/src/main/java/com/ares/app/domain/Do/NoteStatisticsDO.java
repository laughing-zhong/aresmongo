package com.ares.app.domain.Do;

import org.joda.time.DateTime;

import com.ares.framework.domain.MongoKeyDO;

public class NoteStatisticsDO extends MongoKeyDO{
	private int totalCount;
	private int todayNoteCount;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTodayNoteCount() {
		return todayNoteCount;
	}
	public void setTodayNoteCount(int todayNoteCount) {
		this.todayNoteCount = todayNoteCount;
	}
	public int getLastDayCount() {
		return lastDayCount;
	}
	public void setLastDayCount(int lastDayCount) {
		this.lastDayCount = lastDayCount;
	}

	private int lastDayCount;
	private DateTime lstStaticCountTime;
	public DateTime getLstStaticCountTime() {
		return lstStaticCountTime;
	}
	public void setLstStaticCountTime(DateTime lstStaticCountTime) {
		this.lstStaticCountTime = lstStaticCountTime;
	}
}
