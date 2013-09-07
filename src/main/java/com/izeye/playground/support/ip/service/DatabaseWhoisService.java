package com.izeye.playground.support.ip.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ip.dao.WhoisDao;
import com.izeye.playground.support.ip.domain.Whois;
import com.izeye.playground.support.ip.domain.WhoisFailException;

@Service("databaseWhoisService")
public class DatabaseWhoisService implements WhoisService {

	@Resource
	private WhoisDao whoisDao;

	@Override
	public Whois whois(String ip) throws WhoisFailException {
		return whoisDao.get(ip);
	}

	public void save(Whois whois) {
		whoisDao.insert(whois);
	}

}
