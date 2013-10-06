package com.izeye.playground.support.ip.service;

import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.ADDR;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.COUNTRY_CODE;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.COUNTRY_CODE_KR;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.ENGLISH;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.ISP;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.KOREAN;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.NET_INFO;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.ORG_NAME;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.PI;
import static com.izeye.playground.support.ip.domain.KisaWhoisConstants.USER;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.izeye.playground.common.domain.StringConstants;
import com.izeye.playground.common.util.HttpUtils;
import com.izeye.playground.common.util.JDOMUtils;
import com.izeye.playground.common.util.UrlUtils;
import com.izeye.playground.support.country.domain.Country;
import com.izeye.playground.support.country.service.CountryService;
import com.izeye.playground.support.ip.domain.Whois;
import com.izeye.playground.support.ip.domain.WhoisDetail;
import com.izeye.playground.support.ip.domain.WhoisFailException;

@Service("kisaWhoisService")
public class KisaWhoisService implements WhoisService {

	private static final String KISA_WHOIS_API_URL_PREFIX = "http://whois.kisa.or.kr/openapi/whois.jsp?";
	private static final String PARAM_QUERY = "query";
	private static final String PARAM_KEY = "key";

	@Resource
	private CountryService countryService;

	@Value("${kisa.whois.api.key}")
	private String apiKey;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public Whois whois(String ip) throws WhoisFailException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_QUERY, ip);
		params.put(PARAM_KEY, apiKey);

		String apiUrl = UrlUtils.createUrl(KISA_WHOIS_API_URL_PREFIX, params);
		log.debug("API URL: {}", apiUrl);

		InputStream is = null;
		try {
			is = HttpUtils.urlToInputStream(apiUrl);
			Element root = JDOMUtils.inputStreamToRootElement(is);
			Element countryCode = root.getChild(COUNTRY_CODE);

			Whois whois = new Whois();
			whois.setIpAddress(ip);

			String countryCodeText = countryCode.getText().trim();
			Country country = countryService.getCountryByCode(countryCodeText);
			whois.setCountry(country);

			if (countryCodeText.equalsIgnoreCase(COUNTRY_CODE_KR)) {
				Element korean = root.getChild(KOREAN);
				WhoisDetail koreanDetail = getDetail(korean);

				Element english = root.getChild(ENGLISH);
				WhoisDetail englishDetail = getDetail(english);

				whois.setKoreanDetail(koreanDetail);
				whois.setEnglishDetail(englishDetail);
			} else {
				whois.setKoreanDetail(WhoisDetail.NOT_AVAILABLE);
				whois.setEnglishDetail(WhoisDetail.NOT_AVAILABLE);
			}
			return whois;
		} catch (IOException e) {
			e.printStackTrace();
			throw new WhoisFailException("IP: " + ip, e);
		} catch (JDOMException e) {
			e.printStackTrace();
			throw new WhoisFailException("IP: " + ip, e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private WhoisDetail getDetail(Element language) {
		Element isp = language.getChild(ISP);
		if (isp == null) {
			isp = language.getChild(PI);
		}
		Element ispNetInfo = isp.getChild(NET_INFO);
		Element ispOrgName = ispNetInfo.getChild(ORG_NAME);
		Element ispAddr = ispNetInfo.getChild(ADDR);

		String ispOrgNameText = ispOrgName.getText().trim();
		String ispAddrText = ispAddr.getText().trim();

		String userOrgNameText = StringConstants.NOT_AVAILABLE;
		String userAddrText = StringConstants.NOT_AVAILABLE;
		Element user = language.getChild(USER);
		if (user != null) {
			Element userNetInfo = user.getChild(NET_INFO);
			Element userOrgName = userNetInfo.getChild(ORG_NAME);
			Element userAddr = userNetInfo.getChild(ADDR);
			userOrgNameText = userOrgName.getText().trim();
			userAddrText = userAddr.getText().trim();
		}
		return new WhoisDetail(ispOrgNameText, ispAddrText, userOrgNameText,
				userAddrText);
	}

}
