package com.izeye.playground.log.access.domain;

import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;

public class AccessLog {

	private long id;
	private Date accessTime;
	private String ip;
	private String url;
	private String userAgent;
	private String referer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getEscapedUserAgent() {
		return StringEscapeUtils.escapeHtml4(userAgent);
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	@Override
	public String toString() {
		return "AccessLog [id=" + id + ", accessTime=" + accessTime + ", ip="
				+ ip + ", url=" + url + ", userAgent=" + userAgent
				+ ", referer=" + referer + "]";
	}

}
