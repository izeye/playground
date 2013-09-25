package com.izeye.playground.support.naver.service.search.cafe;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.*;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.cafe.NaverSearchCafeItem;
import com.izeye.playground.support.naver.service.AbstractNaverSearchItemParser;

@Service("naverSearchCafeItemParser")
public class NaverSearchCafeItemParser extends
		AbstractNaverSearchItemParser<NaverSearchCafeItem> {

	@Override
	protected void parseSpecific(Element itemElement, NaverSearchCafeItem item) {
		String ranking = itemElement.getChildText(ELEMENT_RANKING);
		int member = Integer.parseInt(itemElement.getChildText(ELEMENT_MEMBER));
		int totalArticles = Integer.parseInt(itemElement
				.getChildText(ELEMENT_TOTAL_ARTICLES));
		int newArticles = Integer.parseInt(itemElement
				.getChildText(ELEMENT_NEW_ARTICLES));

		item.setRanking(ranking);
		item.setMember(member);
		item.setTotalArticles(totalArticles);
		item.setNewArticles(newArticles);
	}

}
