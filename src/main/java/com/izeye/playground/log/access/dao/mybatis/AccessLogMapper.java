package com.izeye.playground.log.access.dao.mybatis;

import java.util.List;

import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.UserAgentCount;

public interface AccessLogMapper {

	void insert(AccessLog accessLog);

	List<AccessLog> getAllAccessLogs();

	List<AccessLog> getAccessLogsInSpecificDate(String date);

	List<DailyCount> getDailyCounts();

	List<AccessLog> getLatestAccessLogs(int count);

	List<UserAgentCount> getUserAgentCounts();

}
