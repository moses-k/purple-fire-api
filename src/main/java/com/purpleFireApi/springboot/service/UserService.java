package com.purpleFireApi.springboot.service;

import java.util.List;

import com.purpleFireApi.springboot.modal.User;

public interface UserService {
	List<User> get();
	
	User get(int id);
	
	void save(User users);
	
	void delete (int id);

}
