package com.izeye.playground.support.ua.service.os;

import com.izeye.playground.support.ua.domain.os.OSInfo;

public interface OSInfoParser {

	OSInfo parse(String osInfoInUserAgent);

}
