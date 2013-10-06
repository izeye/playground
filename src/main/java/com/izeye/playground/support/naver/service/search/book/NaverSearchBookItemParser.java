package com.izeye.playground.support.naver.service.search.book;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_AUTHOR;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_BOOK_PUBLISHED_DATE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_DISCOUNT;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_IMAGE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_ISBN;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_PRICE;
import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.ELEMENT_PUBLISHER;

import java.util.Date;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.book.NaverSearchBookItem;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchItemParser;
import com.izeye.playground.support.naver.util.NaverDateUtils;

@Service("naverSearchBookItemParser")
public class NaverSearchBookItemParser extends
		AbstractNaverSearchItemParser<NaverSearchBookItem> {

	@Override
	protected void parseSpecific(Element itemElement, NaverSearchBookItem item) {
		String image = itemElement.getChildText(ELEMENT_IMAGE);
		String author = itemElement.getChildText(ELEMENT_AUTHOR);
		String priceString = itemElement.getChildText(ELEMENT_PRICE);
		String discountString = itemElement.getChildText(ELEMENT_DISCOUNT);
		Integer price = priceString == null ? null : Integer
				.valueOf(priceString);
		Integer discount = discountString == null ? null : Integer
				.valueOf(discountString);
		String publisher = itemElement.getChildText(ELEMENT_PUBLISHER);
		Date publishedDate = NaverDateUtils.parseDate(itemElement
				.getChildText(ELEMENT_BOOK_PUBLISHED_DATE));
		long isbn = Long.parseLong(itemElement.getChildText(ELEMENT_ISBN)
				.split(" ")[1]);

		item.setImage(image);
		item.setAuthor(author);
		item.setPrice(price);
		item.setDiscount(discount);
		item.setPublisher(publisher);
		item.setPublishedDate(publishedDate);
		item.setIsbn(isbn);
	}

}
