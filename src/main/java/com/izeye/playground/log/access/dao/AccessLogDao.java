package com.izeye.playground.log.access.dao;

import java.util.List;

import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;

public interface AccessLogDao {

	void insert(AccessLog log);

	List<AccessLog> getAllAccessLogs();

	List<AccessLog> getAccessLogsInSpecificDate(String date);

	List<DailyCount> getDailyCounts();

}
