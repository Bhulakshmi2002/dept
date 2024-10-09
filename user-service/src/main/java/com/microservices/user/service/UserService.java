package com.microservices.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.user.entity.UserDone;
import com.microservices.user.repository.UserRepository;
import com.microservices.user.vo.Department;
import com.microservices.user.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public UserDone saveUser(UserDone user) {
		log.info("Inside saveUser of UserService");

		return userRepository.save(user);
	}



//	public ResponseTemplateVo getUserWithDepartment(Long userId) {
//		ResponseTemplateVo vo= new ResponseTemplateVo();
//		UserDone user = userRepository.findByUserId(userId);
//		//return null;
//		Department department = 
//				restTemplate.getForObject( "http://localhost:8082/departments/" + user.getDepartmentId(),  Department.class);
//		vo.setUser(user);
//		
//        vo.setDepartment(department);
//
//        return  vo;
//	}
	
	public ResponseTemplateVo getUserDoneWithDepartment(Long userId) {
		ResponseTemplateVo vo = new ResponseTemplateVo();
		UserDone user = userRepository.findByUserId(userId);
		Department department = restTemplate.getForObject("http://Department-Service/departments/" +  user.getDepartmentId(), Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		 return vo;
	}
	
}
