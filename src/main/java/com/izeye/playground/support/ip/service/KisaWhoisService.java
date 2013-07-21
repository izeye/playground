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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.izeye.playground.common.util.HTTPUtils;
import com.izeye.playground.common.util.JDOMUtils;
import com.izeye.playground.common.util.StringConstants;
import com.izeye.playground.common.util.URLUtils;
import com.izeye.playground.support.country.domain.Country;
import com.izeye.playground.support.country.service.CountryService;
import com.izeye.playground.support.ip.domain.Whois;
import com.izeye.playground.support.ip.domain.WhoisDetail;

@Service("kisaWhoiseService")
public class KisaWhoisService implements WhoisService {

	private static final String KISA_WHOIS_API_URL_PREFIX = "http://whois.kisa.or.kr/openapi/whois.jsp?";
	private static final String PARAM_QUERY = "query";
	private static final String PARAM_KEY = "key";

	@Resource
	private CountryService countryService;

	@Value("${kisa.whois.api.key}")
	private String apiKey;

	@Override
	@Cacheable("whoisCache")
	public Whois whois(String ip) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put(PARAM_QUERY, ip);
		params.put(PARAM_KEY, apiKey);

		String apiUrl = URLUtils.createURL(KISA_WHOIS_API_URL_PREFIX, params);
		try {
			InputStream is = HTTPUtils.urlToInputStream(apiUrl);
			Element root = JDOMUtils.inputStreamToRootElement(is);
			Element countryCode = root.getChild(COUNTRY_CODE);

			Whois whois = new Whois();
			whois.setIpAddress(ip);

			String countryCodeText = countryCode.getText().trim();
			Country country = countryService.getCountryByCode(countryCodeText);
			whois.setCountry(country);

			if (countryCodeText.equals(COUNTRY_CODE_KR)) {
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
		} catch (JDOMException e) {
			e.printStackTrace();
		}
		return null;
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
