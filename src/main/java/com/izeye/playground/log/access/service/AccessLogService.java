package com.izeye.playground.log.access.service;

import java.util.List;

import com.izeye.playground.log.access.domain.AccessLog;

public interface AccessLogService {

	void log(String ip, String url, String userAgent, String referer);

	List<AccessLog> getLatestAccessLogs(int count);

	List<AccessLog> getLatestAccessLogs(long exclusiveBaseId, int count);

	List<AccessLog> getAccessLogsInSpecificDate(String date);

}
