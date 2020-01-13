package com.Forum.Dto;

/**
 *	@Author	  ZFFFlower  ——2020年1月9日
 *	
 * 	创建GitHub传过来的数据用户存储
 */
public class GitHubUser {
	private String name;
	private Long id;	//防止用户数量过大
	private String bio;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}	
}
