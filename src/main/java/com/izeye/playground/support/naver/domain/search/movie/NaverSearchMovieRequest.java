package com.izeye.playground.support.naver.domain.search.movie;

import com.izeye.playground.support.naver.domain.search.NaverSearchRequest;
import com.izeye.playground.support.naver.domain.search.NaverSearchType;

public class NaverSearchMovieRequest extends NaverSearchRequest {

	private Integer genre;
	private String country;
	private Integer yearFrom;
	private Integer yearTo;

	public NaverSearchMovieRequest(String query) {
		super(NaverSearchType.MOVIE, query);
	}

	public NaverSearchMovieRequest(String query, int display, int start) {
		super(NaverSearchType.MOVIE, query, display, start);
	}

	public Integer getGenre() {
		return genre;
	}

	public void setGenre(Integer genre) {
		this.genre = genre;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getYearFrom() {
		return yearFrom;
	}

	public void setYearFrom(Integer yearFrom) {
		this.yearFrom = yearFrom;
	}

	public Integer getYearTo() {
		return yearTo;
	}

	public void setYearTo(Integer yearTo) {
		this.yearTo = yearTo;
	}

	@Override
	public String toString() {
		return "NaverSearchMovieRequest [genre=" + genre + ", country="
				+ country + ", yearFrom=" + yearFrom + ", yearTo=" + yearTo
				+ ", toString()=" + super.toString() + "]";
	}

}
