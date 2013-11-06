package com.izeye.playground.log.access.dao.mybatis;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.izeye.playground.log.access.dao.AccessLogDao;
import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;
import com.izeye.playground.log.access.domain.IpCount;
import com.izeye.playground.log.access.domain.UserAgentCount;

@Repository("accessLogDao")
public class AccessLogDaoMyBatis implements AccessLogDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void insert(AccessLog log) {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		mapper.insert(log);
	}

	@Override
	public List<AccessLog> getLatestAccessLogs(int count) {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getLatestAccessLogs(count);
	}

	@Override
	public List<AccessLog> getLatestAccessLogs(long exclusiveBaseId, int count) {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getLatestAccessLogsWithExclusiveBaseId(exclusiveBaseId,
				count);
	}

	@Override
	@Cacheable("accessLogCache")
	public List<AccessLog> getAccessLogsInSpecificDate(String date) {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getAccessLogsInSpecificDate(date);
	}

	@Override
	@Cacheable(value = "accessLogCache", key = "{#root.methodName}")
	public List<DailyCount> getDailyCounts() {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getDailyCounts();
	}

	@Override
	public List<DailyCount> getDailyCountsBetween(Date startDate, Date endDate) {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getLatestDailyCounts(startDate, endDate);
	}

	@Override
	@Cacheable(value = "accessLogCache", key = "{#root.methodName}")
	public List<UserAgentCount> getUserAgentCounts() {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getUserAgentCounts();
	}

	@Override
	@Cacheable(value = "accessLogCache", key = "{#root.methodName}")
	public List<IpCount> getUserAgentSpamIpCounts() {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getUserAgentSpamIPCounts();
	}

}
