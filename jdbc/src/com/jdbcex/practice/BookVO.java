package com.jdbcex.practice;

import java.sql.Date;

import com.jdbcex.ex01.Author;

public class BookVO {
	
	private int bookId;
	private String title;
	private String pubs;
	private Date pub_date;
	private Author author_id;
	
	public BookVO(int bookId, String title, String pubs, Date pub_date, Author author_id) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.pubs = pubs;
		this.pub_date = pub_date;
		this.author_id = author_id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubs() {
		return pubs;
	}

	public void setPubs(String pubs) {
		this.pubs = pubs;
	}

	public Date getPub_date() {
		return pub_date;
	}

	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}

	public Author getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Author author_id) {
		this.author_id = author_id;
	}

	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", title=" + title + ", pubs=" + pubs + ", pub_date=" + pub_date
				+ ", author_id=" + author_id + "]";
	}
	
	
	

}
