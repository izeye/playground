package com.izeye.playground.log.access.dao.mybatis;

import java.util.List;

import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;

public interface AccessLogMapper {

	void insert(AccessLog accessLog);

	List<AccessLog> getAccessLogsInSpecificDate(String date);

	List<DailyCount> getDailyCounts();

}
