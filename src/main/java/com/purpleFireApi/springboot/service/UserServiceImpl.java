package com.purpleFireApi.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.purpleFireApi.springboot.dao.UserDAO;
import com.purpleFireApi.springboot.modal.User;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Transactional(propagation = Propagation.NESTED)
	@Override
	public List<User> get() {
		return userDao.get();
	}

	@Transactional
	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void save(User users) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	} 

}


