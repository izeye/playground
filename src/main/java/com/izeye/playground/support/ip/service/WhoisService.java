package com.izeye.playground.support.ip.service;

import com.izeye.playground.support.ip.domain.Whois;
import com.izeye.playground.support.ip.domain.WhoisFailException;

public interface WhoisService {

	Whois whois(String ip) throws WhoisFailException;

}
