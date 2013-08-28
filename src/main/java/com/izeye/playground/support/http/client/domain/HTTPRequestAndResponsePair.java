package com.izeye.playground.support.http.client.domain;

public class HTTPRequestAndResponsePair {

	private final HTTPRequest request;
	private final HTTPResponse response;

	public HTTPRequestAndResponsePair(HTTPRequest request, HTTPResponse response) {
		this.request = request;
		this.response = response;
	}

	public HTTPRequest getRequest() {
		return request;
	}

	public HTTPResponse getResponse() {
		return response;
	}

	@Override
	public String toString() {
		return "HTTPRequestAndResponsePair [request=" + request + ", response="
				+ response + "]";
	}

}
