package com.izeye.playground.support.http.client.service;

import com.izeye.playground.support.http.client.domain.HttpClientFailureException;
import com.izeye.playground.support.http.client.domain.HttpRequest;
import com.izeye.playground.support.http.client.domain.HttpResponse;

public interface HttpClient {

	HttpResponse send(HttpRequest request) throws HttpClientFailureException;

	HttpResponse send(HttpRequest request, boolean contentLengthLimited)
			throws HttpClientFailureException;

}
