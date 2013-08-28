package com.izeye.playground.support.http.client.service;

import java.io.InputStream;

import com.izeye.playground.support.http.client.domain.HTTPClientFailureException;
import com.izeye.playground.support.http.client.domain.HTTPResponse;

public interface HTTPResponseParser {

	HTTPResponse parse(InputStream is) throws HTTPClientFailureException;

	HTTPResponse parse(InputStream is, boolean contentLengthLimited)
			throws HTTPClientFailureException;

}
