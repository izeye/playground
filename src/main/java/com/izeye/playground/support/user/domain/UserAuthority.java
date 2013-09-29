package com.izeye.playground.support.user.domain;

public class UserAuthority {

	private Integer id;
	private int userId;
	private String authority;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "UserAuthority [id=" + id + ", userId=" + userId
				+ ", authority=" + authority + "]";
	}

}
