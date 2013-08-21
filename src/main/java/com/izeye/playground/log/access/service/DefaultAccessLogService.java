package com.izeye.playground.log.access.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.log.access.dao.AccessLogDao;
import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.support.spam.ip.service.SpamIPFilter;

@Service("accessLogService")
public class DefaultAccessLogService implements AccessLogService {

	@Resource
	private AccessLogDao accessLogDao;

	@Resource
	private SpamIPFilter spamIPFilter;

	@Override
	public void log(String ip, String url, String userAgent, String referer) {
		AccessLog log = new AccessLog();
		log.setAccessTime(new Date());
		log.setIp(ip);
		log.setUrl(url);
		log.setUserAgent(userAgent);
		log.setReferer(referer);
		accessLogDao.insert(log);
	}

	@Override
	public List<AccessLog> getAllAccessLogs() {
		return accessLogDao.getAllAccessLogs();
	}

	@Override
	public List<AccessLog> getLatestAccessLogs(int count) {
		List<AccessLog> latestAccessLogs = accessLogDao
				.getLatestAccessLogs(count);

		filterSpams(latestAccessLogs);

		return latestAccessLogs;
	}

	@Override
	public List<AccessLog> getLatestAccessLogs(long exclusiveBaseId, int count) {
		return accessLogDao.getLatestAccessLogs(exclusiveBaseId, count);
	}

	private void filterSpams(List<AccessLog> accessLogs) {
		List<AccessLog> filteredAccessLogs = new ArrayList<AccessLog>();
		for (AccessLog accessLog : accessLogs) {
			if (spamIPFilter.filter(accessLog.getIp())) {
				filteredAccessLogs.add(accessLog);
			}
		}
		accessLogs.removeAll(filteredAccessLogs);
	}

}
