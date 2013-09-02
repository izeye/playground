package com.izeye.playground.log.access.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.log.access.dao.AccessLogDao;
import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.support.ip.service.IPAnalyzer;
import com.izeye.playground.support.spam.ip.service.SpamIPFilter;
import com.izeye.playground.support.ua.service.UserAgentAnalyzer;

@Service("accessLogService")
public class DefaultAccessLogService implements AccessLogService {

	@Resource
	private AccessLogDao accessLogDao;

	@Resource
	private SpamIPFilter spamIPFilter;

	@Resource
	private IPAnalyzer ipAnalyzer;

	@Resource
	private UserAgentAnalyzer userAgentAnalyzer;

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

	@Override
	public List<AccessLog> getAccessLogsInSpecificDate(String date) {
		List<AccessLog> accessLogs = accessLogDao
				.getAccessLogsInSpecificDate(date);
		filterSpams(accessLogs);
		analyze(accessLogs);
		return accessLogs;
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

	private void analyze(List<AccessLog> accessLogs) {
		for (AccessLog accessLog : accessLogs) {
			accessLog.setAnalyzedIp(ipAnalyzer.analyze(accessLog.getIp()));
			accessLog.setAnalyzedUserAgent(userAgentAnalyzer.analyze(accessLog
					.getUserAgent()));
		}
	}

}
