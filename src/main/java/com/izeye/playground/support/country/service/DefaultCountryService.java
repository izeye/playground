package com.izeye.playground.support.country.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.country.domain.Country;

@Service("countryService")
public class DefaultCountryService implements CountryService {

	private static final String IGNORABLE_EXCEPTION_MESSAGE = "Couldn't find 3-letter country code for CS";

	private final List<Country> countries = new ArrayList<Country>();
	private final Map<String, Country> codeAndNameMap = new HashMap<String, Country>();

	private final Logger log = LoggerFactory.getLogger(getClass());

	public DefaultCountryService() {
		Locale[] availableLocales = Locale.getAvailableLocales();
		for (Locale locale : availableLocales) {
			try {
				String iso = locale.getISO3Country();
				String code = locale.getCountry();
				String name = locale.getDisplayCountry(Locale.US);
				if (iso.isEmpty() || code.isEmpty() || name.isEmpty()
						|| codeAndNameMap.get(code) != null) {
					continue;
				}
				Country country = new Country(iso, code, name);
				countries.add(country);
				codeAndNameMap.put(code, country);
			} catch (MissingResourceException e) {
				String message = e.getMessage();
				if (!message.equals(IGNORABLE_EXCEPTION_MESSAGE)) {
					log.error("Unexpected exception", e);
				} else {
					log.trace(message);
				}
			}
		}
		Collections.sort(countries, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	@Override
	public List<Country> getAllCountries() {
		return countries;
	}

	@Override
	public Country getCountryByCode(String code) {
		Country country = codeAndNameMap.get(code.toUpperCase());
		return country == null ? Country.NOT_AVAILABLE : country;
	}

}
