package com.model;

public class Article {

	private int id_article;
	private String nom_article;
	private float prix_article;
	private double delai_preparation;

	public Article(int parseInt, String string, float parseFloat) {

		this.setId_article(parseInt);
		this.setNom_article(string);
		this.setPrix_article(parseFloat);
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public int getId_article() {
		return id_article;
	}

	public void setId_article(int id_article) {
		this.id_article = id_article;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public float getPrix_article() {
		return prix_article;
	}

	public void setPrix_article(float prix_article) {
		this.prix_article = prix_article;
	}

	@Override
	public String toString() {
		return "Article [id_article=" + id_article + ", nom_article=" + nom_article + ", prix_article=" + prix_article
				+ "]";
	}

	public double getDelai_preparation() {
		return delai_preparation;
	}

	public void setDelai_preparation(double delai_preparation) {
		this.delai_preparation = delai_preparation;
	}

}
