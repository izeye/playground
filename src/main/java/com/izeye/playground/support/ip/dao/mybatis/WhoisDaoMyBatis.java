package com.izeye.playground.support.ip.dao.mybatis;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.izeye.playground.common.util.JsonUtils;
import com.izeye.playground.support.ip.dao.WhoisDao;
import com.izeye.playground.support.ip.domain.Whois;

@Repository("whoisDao")
public class WhoisDaoMyBatis implements WhoisDao {

	@Resource
	private SqlSession sqlSession;

	@Override
	public void insert(Whois whois) {
		WhoisMapper mapper = sqlSession.getMapper(WhoisMapper.class);
		mapper.insert(whois.getIpAddress(), JsonUtils.toJson(whois));
	}

	@Override
	public Whois get(String ip) {
		WhoisMapper mapper = sqlSession.getMapper(WhoisMapper.class);
		String json = mapper.get(ip);
		if (json == null) {
			return Whois.NOT_AVAILABLE;
		}
		return JsonUtils.parseJson(json, Whois.class);
	}

}
