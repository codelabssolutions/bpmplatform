package com.bpmplatform.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpmplatform.domainobj.UserResponse;
import com.bpmplatform.model.Role;
import com.bpmplatform.model.User;
import com.bpmplatform.service.UserService;

/**
 * @author Dhiraj
 *
 */
@Controller
public class CommonController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Set<Role> roles=new HashSet<Role>();
		Role role=new Role();
		role.setId(1);
		role.setRole("ADMIN");
		roles.add(role);
		user.setRoles(roles);
		
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("login");

		}
		return modelAndView;
	}
	@RequestMapping(value = "/admin/registration1", method = RequestMethod.POST)
	public ModelAndView createNewUser1(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Set<Role> roles=new HashSet<Role>();
		Role role=new Role();
		role.setId(1);
		role.setRole("ADMIN");
		roles.add(role);
		user.setRoles(roles);
		
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult.rejectValue("email", "error.user",
					"There is already a user registered with the email provided");
		}
		 else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("userlist");

		}
		return modelAndView;
	}
	@RequestMapping(value = {"/admin/registrationForm" }, method = RequestMethod.GET)
	public ModelAndView registrationForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		return modelAndView;
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
	public String getUserList(Model model) {
		List<UserResponse> userList = new ArrayList<>(100);
		List <User> allUser=userService.findAllUser();  
		for(User user:allUser) {
			UserResponse userResponse =new UserResponse();
			userResponse.setActive(user.getActive());
			userResponse.setCompanyName(user.getCompanyName());
			userResponse.setContact(user.getContact());
			userResponse.setEmail(user.getEmail());
			userResponse.setFirstName(user.getFirstName());
			userResponse.setLastName(user.getLastName());
			userResponse.setId(user.getId());
			userList.add(userResponse);
		}
	    model.addAttribute("userList", userList);;
		return "/userlist";
	}
    @RequestMapping(value = "/admin/addnotification")
	public String createNotification() {
		return "/addnotification";
	}
    
    @RequestMapping(value = "/admin/viewnotification")
   	public String viewNotification() {
   		return "/viewnotification";
   	}
}
