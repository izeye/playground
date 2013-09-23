package com.izeye.playground.support.naver.domain.search;

import java.util.Date;
import java.util.List;

public interface NaverSearchResponse<T extends NaverSearchItem> {

	Date getLastBuildDate();

	void setLastBuildDate(Date lastBuildDate);

	int getTotal();

	void setTotal(int total);

	int getStart();

	void setStart(int start);

	int getDisplay();

	void setDisplay(int display);

	List<T> getItems();

	void setItems(List<T> items);

}
