package com.izeye.playground.support.country.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.country.domain.Country;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class CountryServiceTest {

	@Resource
	private CountryService countryService;

	@Test
	public void getAllCountries() {
		List<Country> allCountries = countryService.getAllCountries();
		System.out.println(allCountries);
	}

	@Test
	public void getCountryByCode() {
		String countryCode = "KR";
		Country country = countryService.getCountryByCode(countryCode);
		System.out.println(country);

		countryCode = "CS";
		country = countryService.getCountryByCode(countryCode);
		System.out.println(country);

		countryCode = "LB";
		country = countryService.getCountryByCode(countryCode);
		System.out.println(country);

		countryCode = "ZA";
		country = countryService.getCountryByCode(countryCode);
		System.out.println(country);

		countryCode = "KR";
		country = countryService.getCountryByCode(countryCode);
		System.out.println(country);

		countryCode = "kr";
		country = countryService.getCountryByCode(countryCode);
		System.out.println(country);
	}

}
