package com.izeye.playground.support.http.client.service;

import com.izeye.playground.support.http.client.domain.HTTPClientFailureException;
import com.izeye.playground.support.http.client.domain.HTTPRequest;
import com.izeye.playground.support.http.client.domain.HTTPResponse;

public interface HTTPClient {

	HTTPResponse send(HTTPRequest request) throws HTTPClientFailureException;

	HTTPResponse send(HTTPRequest request, boolean contentLengthLimited)
			throws HTTPClientFailureException;

}
