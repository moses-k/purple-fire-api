package com.purpleFireApi.springboot.dao;

import java.util.List;

import com.purpleFireApi.springboot.modal.User;

public interface UserDAO {
	
	List<User> get();
	
	User get(int id);
	
	void save(User users);
	
	void delete (int id);
	
}
