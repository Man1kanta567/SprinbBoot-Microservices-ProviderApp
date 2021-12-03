package com.mnt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnt.model.User;
import com.mnt.repo.IUserManagementRepo;

@Service
public class UserManagementService implements IUserService{

	@Autowired
	IUserManagementRepo repo;
	
	@Override
	public User getUserById(Integer id) {
		if(repo.existsById(id))
		{
			return repo.findById(id).get();
		}
		else 
		return null;
	}

	@Override
	public String saveUser(User user) {
		String result=null;
		if(repo.existsById(user.getId()))
		{
			result= "User already exists with ID:"+user.getId();
		}
		else
		{
			repo.save(user);
			result="User successfully saved with the details-->"+user.getUsername()+"/n"+user.getAddress();
		}
		return result;
	}

	@Override
	public String deleteUserById(Integer id) {
		if(repo.existsById(id))
		{
			repo.deleteById(id);
			return "User successfully removed";
		}
		else
		return "No User with the Id"+id+" to delete..please check again";
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) repo.findAll();
	}

	@Override
	public User updateUser(String address, Integer id) {
		if(repo.existsById(id))
		{
			repo.updateUser(address, id);
			return repo.findById(id).get();
		}
		return null;
	}

}
