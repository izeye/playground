package com.izeye.playground.common.util;

import java.util.Set;

public class StringUtils {

	public static String toRegex(Set<String> set) {
		StringBuilder sb = new StringBuilder();
		for (String element : set) {
			sb.append(element);
			sb.append('|');
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static String replaceAll(String string, Set<String> preSet,
			Set<String> postSet, String target, String replacement) {
		StringBuilder sbRegex = new StringBuilder();
		sbRegex.append('(');
		sbRegex.append(toRegex(preSet));
		sbRegex.append(')');
		sbRegex.append(target);
		sbRegex.append('(');
		sbRegex.append(toRegex(preSet));
		sbRegex.append(')');
		String regex = sbRegex.toString();
		return string.replaceAll(regex, "$1" + replacement + "$2");
	}

}
