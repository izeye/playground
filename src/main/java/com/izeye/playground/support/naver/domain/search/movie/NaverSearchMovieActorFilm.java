package com.izeye.playground.support.naver.domain.search.movie;

public class NaverSearchMovieActorFilm {

	private final String title;
	private final String mission;
	private final String link;

	public NaverSearchMovieActorFilm(String title, String mission, String link) {
		this.title = title;
		this.mission = mission;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public String getMission() {
		return mission;
	}

	public String getLink() {
		return link;
	}

	@Override
	public String toString() {
		return "NaverSearchMovieActorFilm [title=" + title + ", mission="
				+ mission + ", link=" + link + "]";
	}

}
