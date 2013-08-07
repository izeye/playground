package com.izeye.playground.support.encode.url.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service("urlEncodingService")
public class DefaultURLEncodingService implements URLEncodingService {

	private static final String DEFAULT_ENCODING = "UTF-8";

	@Override
	public String encode(String textToEncode)
			throws UnsupportedEncodingException {
		return URLEncoder.encode(textToEncode, DEFAULT_ENCODING);
	}

	@Override
	public String decode(String textToDecode)
			throws UnsupportedEncodingException {
		return URLDecoder.decode(textToDecode, DEFAULT_ENCODING);
	}

}
