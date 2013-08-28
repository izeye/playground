package com.izeye.playground.support.http.client.domain;

public class HTTPClientFailureException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HTTPClientFailureException(String message) {
		super(message);
	}

	public HTTPClientFailureException(Throwable cause) {
		super(cause);
	}

	public HTTPClientFailureException(String message, Throwable cause) {
		super(message, cause);
	}

}
