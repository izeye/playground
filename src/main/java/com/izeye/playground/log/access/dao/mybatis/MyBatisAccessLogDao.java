package com.izeye.playground.log.access.dao.mybatis;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.izeye.playground.log.access.dao.AccessLogDao;
import com.izeye.playground.log.access.domain.AccessLog;

@Repository("accessLogDao")
public class MyBatisAccessLogDao implements AccessLogDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void insert(AccessLog log) {
		AccessLogMapper mapper = sqlSession.getMapper(AccessLogMapper.class);
		mapper.insert(log);
	}

}
