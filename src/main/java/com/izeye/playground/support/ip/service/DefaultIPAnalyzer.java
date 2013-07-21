package com.izeye.playground.support.ip.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ip.domain.IPInfo;

@Service("ipAnalyzer")
public class DefaultIPAnalyzer implements IPAnalyzer {

	@Resource
	private WhoisService whoisService;

	@Override
	public IPInfo analyze(String ip) {
		return new IPInfo(whoisService.whois(ip));
	}

}
