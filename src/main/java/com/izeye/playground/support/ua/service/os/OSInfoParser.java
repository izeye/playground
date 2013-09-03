package com.izeye.playground.support.ua.service.os;

import com.izeye.playground.support.ua.domain.os.OsInfo;

public interface OsInfoParser {

	OsInfo parse(String osInfoInUserAgent);

}
