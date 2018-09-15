package com.bpmplatform.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.bpmplatform.domainobj.UserRequest;
import com.bpmplatform.model.User;


/**
 * @author Dhiraj
 *
 */
public interface UserService {
	public User findUserByEmail(String email);
	public ModelAndView createUser(UserRequest user);
	public List<User> findAllUser();
	public ModelAndView registrationForm();
	public ModelAndView getUserList(ModelAndView model);
}
