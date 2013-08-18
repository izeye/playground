package com.izeye.playground.support.encode.unicode.service;

import org.springframework.stereotype.Service;

@Service("unicodeEncodingService")
public class DefaultUnicodeEncodingService implements UnicodeEncodingService {

	@Override
	public String encode(String textToEncode) {
		StringBuilder sb = new StringBuilder();
		for (char c : textToEncode.toCharArray()) {
			sb.append(Integer.toHexString(c));
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	@Override
	public String decode(String textToDecode) {
		StringBuilder sb = new StringBuilder();
		String[] unicodes = textToDecode.split(",");
		for (String unicode : unicodes) {
			sb.append((char) Integer.parseInt(unicode, 16));
		}
		return sb.toString();
	}

}
