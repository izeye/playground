package com.izeye.playground.support.ua.service.os;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.os.OSInfo;
import com.izeye.playground.support.ua.domain.os.OSType;

@Service("androidOSInfoParser")
public class AndroidOSInfoParser implements OSInfoParser {

	@Override
	public OSInfo parse(String osInfoInUserAgent) {
		String[] splitOsInfo = osInfoInUserAgent.split(" ");
		return new OSInfo(OSType.ANDROID, splitOsInfo[1]);
	}

}
