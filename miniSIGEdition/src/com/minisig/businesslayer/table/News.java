package com.minisig.businesslayer.table;

public class News {

	private int idNews;
	private String typeDataNews;
	private String nameDataNews;
	
	public News(String typeDataNews, String nameDataNews) {

		this.typeDataNews = typeDataNews;
		this.nameDataNews = nameDataNews;
	}
	public int getIdNews() {
		return idNews;
	}
	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}
	public String getTypeDataNews() {
		return typeDataNews;
	}
	public void setTypeDataNews(String typeDataNews) {
		this.typeDataNews = typeDataNews;
	}
	public String getNameDataNews() {
		return nameDataNews;
	}
	public void setNameDataNews(String nameDataNews) {
		this.nameDataNews = nameDataNews;
	}
}
