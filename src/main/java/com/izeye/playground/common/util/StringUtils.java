package com.izeye.playground.common.util;

import java.util.List;
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

	public static String join(Object[] objects, String joint) {
		StringBuilder sb = new StringBuilder();
		if (objects != null && objects.length != 0) {
			sb.append(objects[0]);
			for (int i = 1; i < objects.length; i++) {
				sb.append(joint);
				sb.append(objects[i]);
			}
		}
		return sb.toString();
	}

	public static String join(List<?> objects, String joint) {
		StringBuilder sb = new StringBuilder();
		if (objects != null && objects.size() != 0) {
			sb.append(objects.get(0));
			for (int i = 1; i < objects.size(); i++) {
				sb.append(joint);
				sb.append(objects.get(i));
			}
		}
		return sb.toString();
	}

}
