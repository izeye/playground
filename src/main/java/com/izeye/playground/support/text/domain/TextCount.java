package com.izeye.playground.support.text.domain;

public class TextCount {

	private final int byteCount;
	private final int charCount;
	private final int wordCount;
	private final int lineCount;

	public TextCount(int byteCount, int charCount, int wordCount, int lineCount) {
		this.byteCount = byteCount;
		this.charCount = charCount;
		this.wordCount = wordCount;
		this.lineCount = lineCount;
	}

	public int getByteCount() {
		return byteCount;
	}

	public int getCharCount() {
		return charCount;
	}

	public int getWordCount() {
		return wordCount;
	}

	public int getLineCount() {
		return lineCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + byteCount;
		result = prime * result + charCount;
		result = prime * result + lineCount;
		result = prime * result + wordCount;
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
		TextCount other = (TextCount) obj;
		if (byteCount != other.byteCount)
			return false;
		if (charCount != other.charCount)
			return false;
		if (lineCount != other.lineCount)
			return false;
		if (wordCount != other.wordCount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TextCount [byteCount=" + byteCount + ", charCount=" + charCount
				+ ", wordCount=" + wordCount + ", lineCount=" + lineCount + "]";
	}

}
