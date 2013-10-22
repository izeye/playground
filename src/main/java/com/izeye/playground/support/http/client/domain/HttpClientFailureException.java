package com.izeye.playground.support.http.client.domain;

public class HttpClientFailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpClientFailureException(String message) {
		super(message);
	}

	public HttpClientFailureException(Throwable cause) {
		super(cause);
	}

	public HttpClientFailureException(String message, Throwable cause) {
		super(message, cause);
	}

}
