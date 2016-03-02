package com.ares.framework.domain;

//import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class MongoKeyDO implements Identifiable<String> {
	private String id;
	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}
}
