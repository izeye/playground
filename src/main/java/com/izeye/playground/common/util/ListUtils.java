package com.izeye.playground.common.util;

import java.util.List;

public class ListUtils {

	public static String list2CommaSeparatedStrings(List<?> list) {
		StringBuilder sb = new StringBuilder();
		if (!list.isEmpty()) {
			for (Object element : list) {
				sb.append(element);
				sb.append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

}
