package com.izeye.playground.support.ip.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ip.domain.IpInfo;
import com.izeye.playground.support.ip.domain.WhoisFailException;

@Service("ipAnalyzer")
public class DefaultIpAnalyzer implements IpAnalyzer {

	@Resource
	private WhoisService whoisService;

	@Override
	public IpInfo analyze(String ip) {
		try {
			return new IpInfo(whoisService.whois(ip));
		} catch (WhoisFailException e) {
			e.printStackTrace();
			return IpInfo.NOT_AVAILABLE;
		}
	}

}
