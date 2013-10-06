package com.izeye.playground.support.naver.service.search.movie;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_ACTOR;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_DIRECTOR;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_IMAGE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_MOVIE_PUBLISHED_DATE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_SUBTITLE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_USER_RATING;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieItem;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchItemParser;

@Service("naverSearchMovieItemParser")
public class NaverSearchMovieItemParser extends
		AbstractNaverSearchItemParser<NaverSearchMovieItem> {

	@Override
	protected void parseSpecific(Element itemElement, NaverSearchMovieItem item) {
		String image = itemElement.getChildText(ELEMENT_IMAGE);
		String subtitle = itemElement.getChildText(ELEMENT_SUBTITLE);
		int publishedDate = Integer.parseInt(itemElement
				.getChildText(ELEMENT_MOVIE_PUBLISHED_DATE));
		String director = itemElement.getChildText(ELEMENT_DIRECTOR);
		String actor = itemElement.getChildText(ELEMENT_ACTOR);
		double userRating = Double.parseDouble(itemElement
				.getChildText(ELEMENT_USER_RATING));

		item.setImage(image);
		item.setSubtitle(subtitle);
		item.setPublishedDate(publishedDate);
		item.setDirector(director);
		item.setActor(actor);
		item.setUserRating(userRating);
	}

}
