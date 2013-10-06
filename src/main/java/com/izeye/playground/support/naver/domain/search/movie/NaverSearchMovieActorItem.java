package com.izeye.playground.support.naver.domain.search.movie;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

public class NaverSearchMovieActorItem extends BaseNaverSearchItem {

	private String image;
	private Date birthday;
	private String birthplace;
	private String gender;
	private List<NaverSearchMovieActorFilm> films;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getBirthyear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(birthday);
		return calendar.get(Calendar.YEAR);
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<NaverSearchMovieActorFilm> getFilms() {
		return films;
	}

	public void setFilms(List<NaverSearchMovieActorFilm> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "NaverSearchMovieActorItem [image=" + image + ", birthday="
				+ birthday + ", birthplace=" + birthplace + ", gender="
				+ gender + ", films=" + films + "]";
	}

}
