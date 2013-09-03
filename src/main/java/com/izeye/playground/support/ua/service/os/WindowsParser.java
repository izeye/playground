package com.izeye.playground.support.ua.service.os;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.os.OsInfo;
import com.izeye.playground.support.ua.domain.os.OsType;

@Service("windowsParser")
public class WindowsParser implements OsInfoParser {

	@Override
	public OsInfo parse(String osInfoInUserAgent) {
		String keyInUserAgent = OsType.WINDOWS.getKeyInUserAgent();
		String osVersion = osInfoInUserAgent
				.substring(keyInUserAgent.length() + 1);
		return new OsInfo(OsType.WINDOWS, osVersion);
	}

}
