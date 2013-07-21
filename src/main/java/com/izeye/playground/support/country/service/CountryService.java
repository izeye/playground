package com.izeye.playground.support.country.service;

import java.util.List;

import com.izeye.playground.support.country.domain.Country;

public interface CountryService {

	List<Country> getAllCountries();

	Country getCountryByCode(String code);

}
