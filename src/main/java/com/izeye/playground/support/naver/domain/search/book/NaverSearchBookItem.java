package com.izeye.playground.support.naver.domain.search.book;

import java.util.Date;

import com.izeye.playground.support.naver.domain.search.AbstractNaverSearchItem;
import com.izeye.playground.support.naver.util.NaverDateUtils;

public class NaverSearchBookItem extends AbstractNaverSearchItem {

	private String image;
	private String author;
	private Integer price;
	private Integer discount;
	private String publisher;
	private Date publishedDate;
	private long isbn;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getFormattedPublishedDate() {
		return NaverDateUtils.formatDate(publishedDate);
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "NaverSearchBookItem [image=" + image + ", author=" + author
				+ ", price=" + price + ", discount=" + discount
				+ ", publisher=" + publisher + ", publishedDate="
				+ publishedDate + ", isbn=" + isbn + ", toString()="
				+ super.toString() + "]";
	}

}
