package com.izeye.playground.common.util;

import java.io.IOException;
import java.io.InputStream;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.junit.Test;

public class JDOMUtilsTest {

	@Test
	public void inputStreamToRoot() throws IOException, JDOMException {
		String urlAsString = "http://whois.kisa.or.kr/openapi/whois.jsp?query=125.186.211.36&key=1234";
		InputStream is = HttpUtils.urlToInputStream(urlAsString);
		Element root = JDOMUtils.inputStreamToRootElement(is);
		System.out.println(root);
	}

}
