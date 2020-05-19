package com.kadir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadir.dao.UserDAO;
import com.kadir.entity.User;
import com.kadir.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	@Override
	public User validateUserLogin(String email, String password) {
		//System.out.println("user 2 " + email +" " + password);
		User user = getUserDAO().validateUserLogin(email, password);
		return user;
	}
	
	@Transactional
	@Override
	public void registerUser(User user) {
		userDAO.registerUser(user);
		
	}
	
	@Transactional
	@Override
	public List<User> getUsers() {
		
		return userDAO.getUsers();
	}

}
