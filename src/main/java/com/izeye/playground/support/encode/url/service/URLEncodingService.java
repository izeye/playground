package com.izeye.playground.support.encode.url.service;

import java.io.UnsupportedEncodingException;

public interface URLEncodingService {

	String encode(String textToEncode) throws UnsupportedEncodingException;

	String decode(String textToDecode) throws UnsupportedEncodingException;

}
