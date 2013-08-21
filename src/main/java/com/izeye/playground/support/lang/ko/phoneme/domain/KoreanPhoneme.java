package com.izeye.playground.support.lang.ko.phoneme.domain;

public class KoreanPhoneme {

	private final KoreanPhonemeType type;
	private final Character value;

	public KoreanPhoneme(KoreanPhonemeType type, Character value) {
		this.type = type;
		this.value = value;
	}

	public KoreanPhonemeType getType() {
		return type;
	}

	public Character getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KoreanPhoneme other = (KoreanPhoneme) obj;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "KoreanPhoneme [type=" + type + ", value=" + value + "]";
	}

}
