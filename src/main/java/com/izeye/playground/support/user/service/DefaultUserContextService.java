package com.izeye.playground.support.user.service;

import org.springframework.security.core.context.SecurityContextHolder;

public class DefaultUserContextService implements UserContextService {

	@Override
	public String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
