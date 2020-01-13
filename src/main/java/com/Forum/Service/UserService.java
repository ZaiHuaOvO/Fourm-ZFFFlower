package com.Forum.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Forum.Model.User;

@Service
public interface UserService {

	List<User> getUserList();
	
}
