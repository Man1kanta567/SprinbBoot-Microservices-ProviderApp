package com.mnt.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mnt.model.User;
@Repository
public interface IUserManagementRepo extends CrudRepository<User, Integer>{

	@Transactional
	@Modifying
	@Query(value = "update User set address=:address where id=:id")
	public User updateUser(@Param("address") String address,@Param("id") Integer id );
	
}
