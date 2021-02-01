package com.RestAPI.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.RestAPI.model.UserDetails;

public interface userDetailDao extends JpaRepository<UserDetails, Integer>{
	
	@Query(value = "select * from admin_user where username=:u and password=:p",nativeQuery = true)
	public List<UserDetails> findByUsernameAndPassword(@Param("u") String username,@Param("p") String password);
	
	@Query(value = "select * from admin_user where username=:u",nativeQuery = true)
	public List<UserDetails> findByUsername(@Param("u") String username);
}
