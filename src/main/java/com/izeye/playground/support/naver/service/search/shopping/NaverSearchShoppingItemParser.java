package com.izeye.playground.support.naver.service.search.shopping;

import static com.izeye.playground.support.naver.domain.search.NaverSearchConstants.*;

import org.jdom.Element;
import org.springframework.stereotype.Service;

import com.izeye.playground.support.naver.domain.search.shopping.NaverSearchShoppingItem;
import com.izeye.playground.support.naver.service.search.AbstractNaverSearchItemParser;

@Service("naverSearchShoppingItemParser")
public class NaverSearchShoppingItemParser extends
		AbstractNaverSearchItemParser<NaverSearchShoppingItem> {

	@Override
	protected void parseSpecific(Element itemElement,
			NaverSearchShoppingItem item) {
		String image = itemElement.getChildText(ELEMENT_IMAGE);
		int lowPrice = Integer.parseInt(itemElement
				.getChildText(ELEMENT_LOW_PRICE));
		int highPrice = Integer.parseInt(itemElement
				.getChildText(ELEMENT_HIGH_PRICE));
		String mallName = itemElement.getChildText(ELEMENT_MALL_NAME);
		long productId = Long.parseLong(itemElement
				.getChildText(ELEMENT_PRODUCT_ID));
		int productType = Integer.parseInt(itemElement
				.getChildText(ELEMENT_PRODUCT_TYPE));

		item.setImage(image);
		item.setLowPrice(lowPrice);
		item.setHighPrice(highPrice);
		item.setMallName(mallName);
		item.setProductId(productId);
		item.setProductType(productType);
	}

}
