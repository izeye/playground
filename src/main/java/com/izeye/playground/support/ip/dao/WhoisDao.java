package com.izeye.playground.support.ip.dao;

import com.izeye.playground.support.ip.domain.Whois;

public interface WhoisDao {

	void insert(Whois whois);

	Whois get(String ip);

}
