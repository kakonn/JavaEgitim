package com.kadir.service;

import java.util.List;

import com.kadir.entity.User;

public interface UserService {

	public abstract User validateUserLogin(String email, String password);

	public abstract void registerUser(User user);

	public abstract List<User> getUsers();

}
