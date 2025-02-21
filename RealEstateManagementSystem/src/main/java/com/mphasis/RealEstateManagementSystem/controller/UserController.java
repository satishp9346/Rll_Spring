package com.mphasis.RealEstateManagementSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.RealEstateManagementSystem.dto.UserRequest;

import com.mphasis.RealEstateManagementSystem.entity.User;
import com.mphasis.RealEstateManagementSystem.entity.UserCommonDetails;
import com.mphasis.RealEstateManagementSystem.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userServ;
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody UserRequest userReq) {
		System.out.println(userReq.getUser()+"  "+userReq.getUserCommonDetails());
		if(userServ.addUser(userReq.getUser(),userReq.getUserCommonDetails()))
			return new ResponseEntity<UserRequest>(userReq,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry User Id Already Exists.",HttpStatus.NOT_FOUND);
	}
	@PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest updateUserRequest) {
		System.out.println("Received update request for user: " + updateUserRequest.getUser()+"  "+updateUserRequest.getUserCommonDetails());
		User user = updateUserRequest.getUser();
        UserCommonDetails userCommonDetails = updateUserRequest.getUserCommonDetails();
        if(userServ.updateUser(user, userCommonDetails))
			return new ResponseEntity<UserRequest>(updateUserRequest,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Failed to Update User.",HttpStatus.NOT_FOUND);
    }
	@GetMapping("")
	public ResponseEntity<?> getUser(@RequestParam("email") String email,@RequestParam("password") String pwd) {
		UserRequest user=userServ.checkUser(email,pwd);
		if(user!=null)
			return new ResponseEntity<UserRequest>(user,HttpStatus.OK);
		else
			return new ResponseEntity<String>("Sorry User does not Exists.",HttpStatus.NOT_FOUND);
	}
//	@PutMapping("/update/{id}")
//	public ResponseEntity<?> updateUser(@PathVariable("id") int userId, @RequestBody User user) {
//		if(userServ.getUser(userId).getUserId()==userId) {
//			userServ.updateUser(user);
//			return new ResponseEntity<User>(user,HttpStatus.OK);
//		}
//		else
//			return new ResponseEntity<String>("Sorry User does not Exists.",HttpStatus.NOT_FOUND);
//	}
//	@GetMapping("")
//	public ResponseEntity<?> getAllUsers() {
//		List<User> userList=userServ.getAllUser();
//		if(!userList.isEmpty())
//			return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("Sorry No Users Exists.",HttpStatus.NOT_FOUND);
//	}
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getUser(@PathVariable("id") int userId) {
//		User user=userServ.getUser(userId);
//		if(user!=null)
//			return new ResponseEntity<User>(user,HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("Sorry User does not Exists.",HttpStatus.NOT_FOUND);
//	}
//	@DeleteMapping("delete/{id}")
//	public ResponseEntity<?> deleteUser(@PathVariable("id") int userId) {
//		User user=userServ.deleteUser(userId);
//		if(user!=null)
//			return new ResponseEntity<User>(user,HttpStatus.OK);
//		else
//			return new ResponseEntity<String>("Sorry User does not Exists.",HttpStatus.NOT_FOUND);
//	}
}
