package com.bpmplatform.service;

import com.bpmplatform.model.User;
/**
 * @author Dhiraj
 *
 */
public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
