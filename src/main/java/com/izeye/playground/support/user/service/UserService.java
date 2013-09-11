package com.izeye.playground.support.user.service;

import org.springframework.security.core.userdetails.User;

public interface UserService {
	
	void changeProfile(User user);

}
