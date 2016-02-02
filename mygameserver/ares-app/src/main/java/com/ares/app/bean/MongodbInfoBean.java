package com.ares.app.bean;

import java.util.List;


public class MongodbInfoBean {
  private String text;
  public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public List<MongodbInfoBean> getNodes() {
	return nodes;
}
public void setNodes(List<MongodbInfoBean> nodes) {
	this.nodes = nodes;
}
private List<MongodbInfoBean> nodes;
}


