package com.purpleFireApi.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.purpleFireApi.springboot.modal.User;

@Repository
public class UserDaoImpl implements UserDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<User> get() {
		List<User> result = null;
		try {
			Session currentSession = entityManager.unwrap(Session.class);
			result = currentSession.createQuery("from User", User.class).getResultList();
		} catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}finally{
			System.out.println("***** in finally block");
		}
		
		return result;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User users) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
