package com.Forum.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.Forum.Model.User;

/**
 *	@Author	  ZFFFlower  ——2020年1月13日
 *	
 * 
 */
@Mapper
public interface UserMapperimpl{
	@Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId}),#{token},#{gmt_create},#{gmt_modified}")
	public void insert(User user);
}
