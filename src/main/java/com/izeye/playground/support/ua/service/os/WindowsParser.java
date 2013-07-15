package com.izeye.playground.support.ua.service.os;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.os.OSInfo;
import com.izeye.playground.support.ua.domain.os.OSType;

@Service("windowsParser")
public class WindowsParser implements OSInfoParser {

	@Override
	public OSInfo parse(String osInfoInUserAgent) {
		String keyInUserAgent = OSType.WINDOWS.getKeyInUserAgent();
		String osVersion = osInfoInUserAgent
				.substring(keyInUserAgent.length() + 1);
		return new OSInfo(OSType.WINDOWS, osVersion);
	}

}
