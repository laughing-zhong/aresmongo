package com.ares.app.domain.Do;

import java.util.List;

import com.ares.framework.domain.MongoKeyDO;

public class RoleDO extends MongoKeyDO{
	public enum RoleType{
		CUSTMER,
		DEV	
	}
	private String accountId;
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public RoleType getType() {
		return type;
	}
	public void setType(RoleType type) {
		this.type = type;
	}
	public List<String> getParentsIds() {
		return parentsIds;
	}
	public void setParentsIds(List<String> parentsIds) {
		this.parentsIds = parentsIds;
	}
	public List<String> getChildrenIds() {
		return childrenIds;
	}
	public void setChildrenIds(List<String> childrenIds) {
		this.childrenIds = childrenIds;
	}
	private String nickName;
	private String role;
	private RoleType type;
	private List<String> parentsIds;
	private List<String>childrenIds;
}
