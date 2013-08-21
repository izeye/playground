package com.izeye.playground.log.access.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.IPCount;
import com.izeye.playground.log.access.domain.UserAgentCount;

public interface AccessLogMapper {

	void insert(AccessLog accessLog);

	List<AccessLog> getAllAccessLogs();

	List<AccessLog> getLatestAccessLogs(int count);

	List<AccessLog> getLatestAccessLogsWithExclusiveBaseId(
			@Param("exclusiveBaseId") long exclusiveBaseId,
			@Param("count") int count);

	List<AccessLog> getAccessLogsInSpecificDate(String date);

	List<DailyCount> getDailyCounts();

	List<UserAgentCount> getUserAgentCounts();

	List<IPCount> getUserAgentSpamIPCounts();

}
