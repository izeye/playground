package com.izeye.playground.log.access.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.IpCount;
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

	List<DailyCount> getLatestDailyCounts(@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);

	List<DailyCount> getDailyCountsWithCount(int count);

	List<UserAgentCount> getUserAgentCounts();

	List<IpCount> getUserAgentSpamIPCounts();

}
