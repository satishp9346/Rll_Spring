package com.mphasis.RealEstateManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.RealEstateManagementSystem.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select user from User user where user.email=:email and user.password=:password")
	public User checkUser(@Param("email") String email,@Param("password") String pwd);

	@Query("select user from User user where user.email=:email")
	public User getUserByEmail(@Param("email") String email);

		
	
}
