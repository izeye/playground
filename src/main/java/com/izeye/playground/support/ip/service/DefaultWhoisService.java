package com.izeye.playground.support.ip.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.ip.domain.Whois;
import com.izeye.playground.support.ip.domain.WhoisFailException;

@Service("whoisService")
public class DefaultWhoisService implements WhoisService {

	@Resource
	private DatabaseWhoisService databaseWhoisService;

	@Resource(name = "kisaWhoisService")
	private WhoisService kisaWhoisService;

	@Cacheable("whoisCache")
	@Override
	public Whois whois(String ip) throws WhoisFailException {
		Whois whois = databaseWhoisService.whois(ip);
		if (whois != Whois.NOT_AVAILABLE) {
			return whois;
		}
		whois = kisaWhoisService.whois(ip);

		// NOTE:
		// Save it in database.
		databaseWhoisService.save(whois);
		return whois;
	}

}
