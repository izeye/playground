package com.izeye.playground.support.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import com.izeye.playground.support.user.domain.User;

public class DefaultPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		if (targetDomainObject instanceof User) {
			User user = (User) targetDomainObject;
			if (permission.equals("changeProfile")) {
				return authentication.getName().equals(user.getName());
			}
		}
		throw new UnsupportedOperationException("hasPermission not supported");
	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		throw new UnsupportedOperationException("Not supported");
	}

}
