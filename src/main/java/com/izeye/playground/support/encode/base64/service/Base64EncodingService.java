package com.izeye.playground.support.encode.base64.service;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

public interface Base64EncodingService {

	String encode(String textToEncode);

	String decode(String textToDecode) throws Base64DecodingException;

}
