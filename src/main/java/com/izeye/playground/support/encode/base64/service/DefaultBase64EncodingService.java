package com.izeye.playground.support.encode.base64.service;

import org.springframework.stereotype.Service;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

@Service("base64EncodingService")
public class DefaultBase64EncodingService implements Base64EncodingService {

	@Override
	public String encode(String textToEncode) {
		return Base64.encode(textToEncode.getBytes());
	}

	@Override
	public String decode(String textToDecode) throws Base64DecodingException {
		return new String(Base64.decode(textToDecode));
	}

}
