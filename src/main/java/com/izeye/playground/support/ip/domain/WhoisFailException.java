package com.izeye.playground.support.ip.domain;

public class WhoisFailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WhoisFailException(String message, Throwable cause) {
		super(message, cause);
	}

	public WhoisFailException(String message) {
		super(message);
	}

}
