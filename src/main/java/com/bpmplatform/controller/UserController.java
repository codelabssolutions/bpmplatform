package com.bpmplatform.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpmplatform.domainobj.UserRequest;
import com.bpmplatform.model.User;
import com.bpmplatform.service.UserService;

/**
 * @author Dhiraj
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
		

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid UserRequest userRequest, BindingResult bindingResult) {
		return userService.createUser(userRequest);
	}
	@RequestMapping(value = "/admin/registration1", method = RequestMethod.POST)
	public ModelAndView createNewUser1(@Valid UserRequest userRequest, BindingResult bindingResult) {
		return userService.createUser(userRequest);
	}
	@RequestMapping(value = {"/admin/registrationForm" }, method = RequestMethod.GET)
	public ModelAndView registrationForm() {
		 return userService.registrationForm();
	}
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping(value = "index")
	public String draw() {
		return "/index";
	}
    @RequestMapping(value = "/admin/userlist")
	public ModelAndView getUserList(ModelAndView model) {
		return userService.getUserList(model);
	}
  
}
