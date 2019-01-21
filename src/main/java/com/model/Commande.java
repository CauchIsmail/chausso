package com.model;

import java.util.Date;

public class Commande {

	
	private int id_cmd;
	private Article article;
	private int quantite;
	private Date dateCommande;
	private int stock_moment_commande;
	private double delai_moment_commande;
	private double delai_preparation_moment_commande;
	
	
	


	public int getId_cmd() {
		return id_cmd;
	}




	public void setId_cmd(int id_cmd) {
		this.id_cmd = id_cmd;
	}








	public int getQuantite() {
		return quantite;
	}




	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}






	public Date getDateCommande() {
		return dateCommande;
	}




	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}




	@Override
	public String toString() {
		return "Commande [id_cmd=" + id_cmd + ", article=" + article + ", quantite=" + quantite + ", dateCommande="
				+ dateCommande + ", stock_moment_commande=" + stock_moment_commande + ", delai_moment_commande="
				+ delai_moment_commande + ", delai_preparation_moment_commande=" + delai_preparation_moment_commande
				+ "]";
	}




	public Article getArticle() {
		return article;
	}




	public void setArticle(Article article) {
		this.article = article;
	}




	public int getStock_moment_commande() {
		return stock_moment_commande;
	}




	public void setStock_moment_commande(int stock_moment_commande) {
		this.stock_moment_commande = stock_moment_commande;
	}




	public double getDelai_moment_commande() {
		return delai_moment_commande;
	}




	public void setDelai_moment_commande(double delai_moment_commande) {
		this.delai_moment_commande = delai_moment_commande;
	}




	public double getDelai_preparation_moment_commande() {
		return delai_preparation_moment_commande;
	}




	public void setDelai_preparation_moment_commande(double delai_preparation_moment_commande) {
		this.delai_preparation_moment_commande = delai_preparation_moment_commande;
	}

}
