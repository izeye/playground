package com.izeye.playground.support.ua.service.os;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.os.OsInfo;
import com.izeye.playground.support.ua.domain.os.OsType;

@Service("androidOsInfoParser")
public class AndroidOsInfoParser implements OsInfoParser {

	@Override
	public OsInfo parse(String osInfoInUserAgent) {
		String[] splitOsInfo = osInfoInUserAgent.split(" ");
		return new OsInfo(OsType.ANDROID, splitOsInfo[1]);
	}

}
