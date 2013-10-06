package com.izeye.playground.support.naver.service.search.movie;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_BIRTHDAY;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_BIRTHPLACE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_FILM;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_GENDER;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_IMAGE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_LINK;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_MISSION;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_TITLE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieActorFilm;
import com.izeye.playground.support.naver.domain.search.movie.NaverSearchMovieActorItem;
import com.izeye.playground.support.naver.service.AbstractNaverSearchItemParser;
import com.izeye.playground.support.naver.util.NaverDateUtils;

@Service("naverSearchMovieActorItemParser")
public class NaverSearchMovieActorItemParser extends
		AbstractNaverSearchItemParser<NaverSearchMovieActorItem> {

	@Override
	protected void parseSpecific(Element itemElement,
			NaverSearchMovieActorItem item) {
		String image = itemElement.getChildText(ELEMENT_IMAGE);
		Date birthday = NaverDateUtils.parseDate(itemElement
				.getChildText(ELEMENT_BIRTHDAY));
		String birthplace = itemElement.getChildText(ELEMENT_BIRTHPLACE);
		String gender = itemElement.getChildText(ELEMENT_GENDER);

		List<NaverSearchMovieActorFilm> films = new ArrayList<NaverSearchMovieActorFilm>();
		@SuppressWarnings("unchecked")
		List<Element> filmElements = itemElement.getChildren(ELEMENT_FILM);
		for (Element filmElement : filmElements) {
			String title = filmElement.getChildText(ELEMENT_TITLE);
			String mission = filmElement.getChildText(ELEMENT_MISSION);
			String link = filmElement.getChildText(ELEMENT_LINK);
			films.add(new NaverSearchMovieActorFilm(title, mission, link));
		}

		item.setImage(image);
		item.setBirthday(birthday);
		item.setBirthplace(birthplace);
		item.setGender(gender);
		item.setFilms(films);
	}

}
