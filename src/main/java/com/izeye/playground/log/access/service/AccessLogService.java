package com.izeye.playground.log.access.service;

public interface AccessLogService {

	void log(String ip, String url, String userAgent, String referer);

}
