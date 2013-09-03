package com.izeye.playground.log.access.dao;

import java.util.List;

import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.IpCount;
import com.izeye.playground.log.access.domain.UserAgentCount;

public interface AccessLogDao {

	void insert(AccessLog log);

	List<AccessLog> getAllAccessLogs();

	List<AccessLog> getLatestAccessLogs(int count);

	List<AccessLog> getLatestAccessLogs(long exclusiveBaseId, int count);

	List<AccessLog> getAccessLogsInSpecificDate(String date);

	List<DailyCount> getDailyCounts();

	List<UserAgentCount> getUserAgentCounts();

	List<IpCount> getUserAgentSpamIpCounts();

}
