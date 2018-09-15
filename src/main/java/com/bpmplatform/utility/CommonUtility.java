package com.bpmplatform.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.bpmplatform.model.User;
import com.bpmplatform.service.UserService;
@Service("commonUtility")
public class CommonUtility {
	@Autowired
	private  UserService userService;
	
	public  User getUserByUserName() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	   	String loggedName = auth.getName(); //get logged in username
    	System.out.println("==========loggedName==============="+loggedName);
	   	return userService.findUserByEmail(loggedName) ;
	} 
	
}
