package com.izeye.playground.support.http.client.service;

import java.io.InputStream;

import com.izeye.playground.support.http.client.domain.HttpClientFailureException;
import com.izeye.playground.support.http.client.domain.HttpResponse;

public interface HttpResponseParser {

	HttpResponse parse(InputStream is) throws HttpClientFailureException;

	HttpResponse parse(InputStream is, boolean contentLengthLimited)
			throws HttpClientFailureException;

}
