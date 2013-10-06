package com.izeye.playground.support.naver.domain.search.movie;

import com.izeye.playground.support.naver.domain.search.BaseNaverSearchItem;

public class NaverSearchMovieItem extends BaseNaverSearchItem {

	private String image;
	private String subtitle;
	private int publishedDate;
	private String director;
	private String actor;
	private double userRating;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public int getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(int publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public double getUserRating() {
		return userRating;
	}

	public void setUserRating(double userRating) {
		this.userRating = userRating;
	}

	@Override
	public String toString() {
		return "NaverSearchMovieItem [image=" + image + ", subtitle="
				+ subtitle + ", publishedDate=" + publishedDate + ", director="
				+ director + ", actor=" + actor + ", userRating=" + userRating
				+ ", toString()=" + super.toString() + "]";
	}

}
