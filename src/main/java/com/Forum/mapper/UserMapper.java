package com.Forum.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.Forum.Model.User;

@Mapper
public class UserMapper implements UserMapperimpl{
	
	@Insert("insert into user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId}),#{token},#{gmt_create},#{gmt_modified}")
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}
	

}
