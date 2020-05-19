package com.kadir.dao;

import java.util.List;

import com.kadir.entity.User;

public interface UserDAO {

	public User validateUserLogin(String email, String password);

	public void registerUser(User user);

	public List<User> getUsers();



}
