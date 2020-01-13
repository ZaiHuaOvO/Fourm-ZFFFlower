package com.Forum.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Forum.Model.User;
import com.Forum.mapper.UserMapper;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getUserList() {

		try {
			List<User> users = userMapper.getUserList();

			return users;
		} catch (Exception e) {
			throw e;
//	            return null;
		}
	}
}
