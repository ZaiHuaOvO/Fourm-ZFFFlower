package com.Forum.Model;
/**
 *	@Author	  ZFFFlower  ——2020年1月13日
 *	
 * 
 */
public class User {
	private Integer id;
	private String name;
	private String accountId;
	private String token;
	private Long qmtCreate;
	private Long qmtModified;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getQmtCreate() {
		return qmtCreate;
	}
	public void setQmtCreate(Long qmtCreate) {
		this.qmtCreate = qmtCreate;
	}
	public Long getQmtModified() {
		return qmtModified;
	}
	public void setQmtModified(Long qmtModified) {
		this.qmtModified = qmtModified;
	}
	
	
}

