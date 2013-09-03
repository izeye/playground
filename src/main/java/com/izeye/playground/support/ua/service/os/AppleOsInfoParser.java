package com.izeye.playground.support.ua.service.os;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;
import com.izeye.playground.support.ua.domain.os.OsInfo;
import com.izeye.playground.support.ua.domain.os.OsType;

@Service("appleOSInfoParser")
public class AppleOsInfoParser implements OsInfoParser {

	private static final String IOS_IPHONE_KEY = "CPU iPhone OS";
	private static final String IOS_IPAD_KEY = "CPU OS";

	@Override
	public OsInfo parse(String osInfoInUserAgent) {
		String maxOSXKey = OsType.MAC_OS_X.getKeyInUserAgent();

		String osKey;
		OsType osType;
		if (osInfoInUserAgent.contains(maxOSXKey)) {
			osKey = maxOSXKey;
			osType = OsType.MAC_OS_X;
		} else if (osInfoInUserAgent.contains(IOS_IPHONE_KEY)) {
			osKey = IOS_IPHONE_KEY;
			osType = OsType.IOS;
		} else if (osInfoInUserAgent.contains(IOS_IPAD_KEY)) {
			osKey = IOS_IPAD_KEY;
			osType = OsType.IOS;
		} else {
			throw new UnidentifiableUserAgentException(
					"Unexpected OS information: " + osInfoInUserAgent);
		}
		String osVersion = osInfoInUserAgent.substring(osKey.length() + 1)
				.split(" ")[0].replace("_", ".");
		return new OsInfo(osType, osVersion);
	}

}
