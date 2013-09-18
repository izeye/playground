package com.izeye.playground.support.user.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.user.domain.User;

@Service("userService")
public class DefaultUserService implements UserService {

	@Override
	@PreAuthorize("hasRole('ROLE_SUPERVISOR') or #user.name == authentication.name")
	// @PreAuthorize("hasPermission(#user, 'changeProfile')")
	public void changeProfile(User user) {
		// TODO Auto-generated method stub

	}

}
