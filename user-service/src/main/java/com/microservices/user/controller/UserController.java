package com.microservices.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.entity.UserDone;
import com.microservices.user.service.UserService;
import com.microservices.user.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public UserDone saveUser(@RequestBody UserDone user) {
		log.info("Inside saveUser of UserController");
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVo getUseDonerWithDepartment(@PathVariable("id")Long userId) {
		log.info("Inside getUserWithDepartment of UserController");
		return userService.getUserDoneWithDepartment(userId);
	}
}
