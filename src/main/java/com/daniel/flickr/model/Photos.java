package com.daniel.flickr.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photos {
	private int page;
	private int pages;
	private int total;
	private List<Photo> photo = new ArrayList<Photo>();
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Photo> getPhoto() {
		return photo;
	}
	public void setPhotos(List<Photo> photo) {
		this.photo = photo;
	}
	

}
