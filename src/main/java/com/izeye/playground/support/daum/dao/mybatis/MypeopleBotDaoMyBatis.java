package com.izeye.playground.support.daum.dao.mybatis;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.izeye.playground.support.daum.dao.MypeopleBotDao;
import com.izeye.playground.support.daum.domain.MypeopleBotCallbackLog;

@Repository("mypeopleBotDao")
public class MypeopleBotDaoMyBatis implements MypeopleBotDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void insert(MypeopleBotCallbackLog callbackLog) {
		MypeopleBotMapper mapper = sqlSession
				.getMapper(MypeopleBotMapper.class);
		mapper.insert(callbackLog);
	}

}
