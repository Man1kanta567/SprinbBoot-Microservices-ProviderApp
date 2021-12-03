package com.mnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mnt.model.User;
import com.mnt.service.UserManagementService;

@RestController
public class UserController 
{
	
	@Autowired
	private UserManagementService service;

	@GetMapping("/one/{id}")
	public User finduser(@PathVariable("id") Integer id)
	{
	   return 	service.getUserById(id);
	}
	
	@PostMapping("/save")
	public String addUser(@RequestBody User user)
	{
		return service.saveUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteuser(@PathVariable("id") Integer id)
	{
		return service.deleteUserById(id);
	}
	
	@GetMapping("/findAll")
	public List<User> findAllUsers()
	{
		return service.getAllUsers();
	}
	
	@PutMapping("/update/{address}/{id}")
	public User updateuser(@PathVariable("address") String address, @PathVariable("id") Integer id)
	{
		return service.updateUser(address, id);
	}
}
