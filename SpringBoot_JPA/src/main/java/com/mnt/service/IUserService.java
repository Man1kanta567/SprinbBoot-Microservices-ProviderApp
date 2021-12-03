package com.mnt.service;

import java.util.List;

import com.mnt.model.User;

public interface IUserService {
	
	public User getUserById(Integer id);
	
	public String saveUser(User user);
	
	public String deleteUserById(Integer id);
	
	public List<User> getAllUsers();
	
	public User updateUser(String address,Integer id);

}
