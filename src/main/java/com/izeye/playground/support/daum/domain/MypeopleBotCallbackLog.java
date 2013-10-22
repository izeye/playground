package com.izeye.playground.support.daum.domain;

import java.util.Date;

public class MypeopleBotCallbackLog {

	private Long id;
	private Date createdTime;
	private String action;
	private String groupId;
	private String buddyId;
	private String content;

	public MypeopleBotCallbackLog() {
	}

	public MypeopleBotCallbackLog(String action, String groupId, String buddyId,
			String content) {
		this.action = action;
		this.groupId = groupId;
		this.buddyId = buddyId;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getBuddyId() {
		return buddyId;
	}

	public void setBuddyId(String buddyId) {
		this.buddyId = buddyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "MypeopleCallbackLog [id=" + id + ", createdTime=" + createdTime
				+ ", action=" + action + ", groupId=" + groupId + ", buddyId="
				+ buddyId + ", content=" + content + "]";
	}

}
