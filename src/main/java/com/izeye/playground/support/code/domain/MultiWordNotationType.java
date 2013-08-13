package com.izeye.playground.support.code.domain;

public enum MultiWordNotationType {

	WORDS("Words") {
		@Override
		public String toWords(String s) {
			return s;
		}

		@Override
		public String toCamelCase(String s) {
			StringBuilder sb = new StringBuilder();
			String[] words = s.split(" ");
			sb.append(words[0].toLowerCase());
			for (int i = 1; i < words.length; i++) {
				String word = words[i];
				sb.append(Character.toUpperCase(word.charAt(0)));
				if (word.length() > 1) {
					sb.append(word.substring(1).toLowerCase());
				}
			}
			return sb.toString();
		}

		@Override
		public String toUnderscore(String s) {
			StringBuilder sb = new StringBuilder();
			String[] words = s.split(" ");
			for (int i = 0; i < words.length; i++) {
				if (i != 0) {
					sb.append('_');
				}
				sb.append(words[i].toUpperCase());
			}
			return sb.toString();
		}

		@Override
		public String convert(String sourceString,
				MultiWordNotationType sourceType) {
			return sourceType.toWords(sourceString);
		}
	},
	CAMEL_CASE("CamelCase") {
		@Override
		public String toWords(String s) {
			StringBuilder sb = new StringBuilder();
			for (char c : s.toCharArray()) {
				if (Character.isUpperCase(c)) {
					sb.append(' ');
					sb.append(Character.toLowerCase(c));
				} else {
					sb.append(c);
				}
			}
			return sb.toString();
		}

		@Override
		public String toCamelCase(String s) {
			return s;
		}

		@Override
		public String toUnderscore(String s) {
			return MultiWordNotationType.WORDS.toUnderscore(toWords(s));
		}

		@Override
		public String convert(String sourceString,
				MultiWordNotationType sourceType) {
			return sourceType.toCamelCase(sourceString);
		}
	},
	UNDERSCORE("Underscore") {
		@Override
		public String toWords(String s) {
			StringBuilder sb = new StringBuilder();
			String[] words = s.split("_");
			for (int i = 0; i < words.length; i++) {
				if (i != 0) {
					sb.append(' ');
				}
				sb.append(words[i].toLowerCase());
			}
			return sb.toString();
		}

		@Override
		public String toCamelCase(String s) {
			return MultiWordNotationType.WORDS.toCamelCase(toWords(s));
		}

		@Override
		public String toUnderscore(String s) {
			return s;
		}

		@Override
		public String convert(String sourceString,
				MultiWordNotationType sourceType) {
			return sourceType.toUnderscore(sourceString);
		}
	};

	private final String name;

	private MultiWordNotationType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract String toWords(String s);

	public abstract String toCamelCase(String s);

	public abstract String toUnderscore(String s);

	public abstract String convert(String sourceString,
			MultiWordNotationType sourceType);

}
