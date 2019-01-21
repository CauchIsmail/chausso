package com.model;

public class Stock {

	private Article article;
	private int stock;
	private double delai;

	public Stock(Article article, int stock, double delai) {
		this.article = article;
		this.stock = stock;
		this.delai = delai;
	}

	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getDelai() {
		return delai;
	}

	public void setDelai(double delai) {
		this.delai = delai;
	}

	@Override
	public String toString() {
		return "Stock [article=" + article + ", stock=" + stock + ", delai=" + delai + "]";
	}

}
