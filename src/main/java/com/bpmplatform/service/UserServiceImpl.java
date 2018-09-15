package com.bpmplatform.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bpmplatform.domainobj.UserRequest;
import com.bpmplatform.domainobj.UserResponse;
import com.bpmplatform.model.Role;
import com.bpmplatform.model.User;
import com.bpmplatform.repository.RoleRepository;
import com.bpmplatform.repository.UserRepository;
/**
 * @author Dhiraj
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
  	@Override
	public ModelAndView createUser(UserRequest userRequest) {
		ModelAndView modelAndView = new ModelAndView();
		User user =new User();
		User userExists = userRepository.findByEmail(userRequest.getEmail());
		if (userExists != null) {
			 //bindingResult.rejectValue("email", "error.user", "There is already a user registered with the email provided");
			modelAndView.addObject("successMessage", "There is already a user registered with the email provided");
			modelAndView. setViewName("redirect:/admin/registrationForm"); 
		} else {
			// Set User role
			Set<Role> roles=new HashSet<Role>();
			Role role=roleRepository.findOne(userRequest.getRoleId());
			roles.add(role);
			user.setRoles(roles);
			user.setActive(0);
			user.setCompanyName(userRequest.getCompanyName());
			user.setContactNo(userRequest.getContactNo());
			user.setFirstName(userRequest.getFirstName());
			user.setLastName(userRequest.getLastName());
			user.setEmail(userRequest.getEmail());
			user.setPassword(userRequest.getPassword());
			userRepository.save(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("redirect:/admin/userlist");
			
		}
		return  modelAndView;

	}
 
 	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}

	@Override
	public ModelAndView registrationForm() {
		ModelAndView modelAndView = new ModelAndView();
		List<Role> roles= roleRepository.findAll();
		modelAndView.addObject("roles",roles);
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@Override
	public ModelAndView getUserList(ModelAndView modelAndView) {
		List<UserResponse> userList = new ArrayList<>(100);
		List <User> allUser=userRepository.findAll();
		for(User user:allUser) {
			UserResponse userResponse =new UserResponse();
			userResponse.setActive(user.getActive());
			userResponse.setCompanyName(user.getCompanyName());
			userResponse.setContact(user.getContactNo());
			userResponse.setEmail(user.getEmail());
			userResponse.setFirstName(user.getFirstName());
			userResponse.setLastName(user.getLastName());
			userResponse.setId(user.getId());
			userList.add(userResponse);
		}
		modelAndView.addObject("userList", userList);
	    modelAndView.setViewName("/userlist");
		return modelAndView;
	} 
	
	

}
