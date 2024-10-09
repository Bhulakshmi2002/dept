package com.microservices.user.vo;

import com.microservices.user.entity.UserDone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {
	
	private UserDone user;
	private Department department;
}
