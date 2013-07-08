package com.izeye.playground.log.access.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.izeye.playground.log.access.dao.AccessLogDao;
import com.izeye.playground.log.access.domain.AccessLog;
import com.izeye.playground.log.access.domain.DailyCount;

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
	@Cacheable("accessLogCache")
	public List<AccessLog> getAllAccessLogs() {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getAllAccessLogs();
	}

	@Override
	@Cacheable("accessLogCache")
	public List<AccessLog> getAccessLogsInSpecificDate(String date) {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getAccessLogsInSpecificDate(date);
	}

	@Override
	@Cacheable("accessLogCache")
	public List<DailyCount> getDailyCounts() {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		return mapper.getDailyCounts();
	}

}
