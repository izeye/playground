package com.izeye.playground.support.http.client.domain;

public class HttpRequestAndResponsePair {

	private final HttpRequest request;
	private final HttpResponse response;

	public HttpRequestAndResponsePair(HttpRequest request, HttpResponse response) {
		this.request = request;
		this.response = response;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public HttpResponse getResponse() {
		return response;
	}

	@Override
	public String toString() {
		return "HTTPRequestAndResponsePair [request=" + request + ", response="
				+ response + "]";
	}

}
