package com.izeye.playground.support.ua.service.os;

import org.springframework.stereotype.Service;

import com.izeye.playground.support.ua.domain.UnidentifiableUserAgentException;
import com.izeye.playground.support.ua.domain.os.OSInfo;
import com.izeye.playground.support.ua.domain.os.OSType;

@Service("appleOSInfoParser")
public class AppleOSInfoParser implements OSInfoParser {

	private static final String IOS_IPHONE_KEY = "CPU iPhone OS";
	private static final String IOS_IPAD_KEY = "CPU OS";

	@Override
	public OSInfo parse(String osInfoInUserAgent) {
		String maxOSXKey = OSType.MAC_OS_X.getKeyInUserAgent();

		String osKey;
		OSType osType;
		if (osInfoInUserAgent.contains(maxOSXKey)) {
			osKey = maxOSXKey;
			osType = OSType.MAC_OS_X;
		} else if (osInfoInUserAgent.contains(IOS_IPHONE_KEY)) {
			osKey = IOS_IPHONE_KEY;
			osType = OSType.IOS;
		} else if (osInfoInUserAgent.contains(IOS_IPAD_KEY)) {
			osKey = IOS_IPAD_KEY;
			osType = OSType.IOS;
		} else {
			throw new UnidentifiableUserAgentException(
					"Unexpected OS information: " + osInfoInUserAgent);
		}
		String osVersion = osInfoInUserAgent.substring(osKey.length() + 1)
				.split(" ")[0].replace("_", ".");
		return new OSInfo(osType, osVersion);
	}

}
