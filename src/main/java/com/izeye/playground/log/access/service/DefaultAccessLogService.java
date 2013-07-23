package com.izeye.playground.log.access.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.log.access.dao.AccessLogDao;
import com.izeye.playground.log.access.domain.AccessLog;

@Service("accessLogService")
public class DefaultAccessLogService implements AccessLogService {

	@Resource
	private AccessLogDao accessLogDao;

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
		return accessLogDao.getLatestAccessLogs(count);
	}

	@Override
	public List<AccessLog> getLatestAccessLogs(long exclusiveBaseId, int count) {
		return accessLogDao.getLatestAccessLogs(exclusiveBaseId, count);
	}

}
