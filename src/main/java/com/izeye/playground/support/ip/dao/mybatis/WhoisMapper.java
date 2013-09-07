package com.izeye.playground.support.ip.dao.mybatis;

import org.apache.ibatis.annotations.Param;

public interface WhoisMapper {

	void insert(@Param("ip") String ip, @Param("whois") String whois);

	String get(String ip);

}
