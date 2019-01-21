package com.service.commande;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.bdd.proprietes.BCommande;
import com.bdd.proprietes.BStock;
import com.model.Article;
import com.model.Commande;


public class CommandeRowMapper implements RowMapper<Commande> {
	public Commande mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Commande commande = new Commande();
		Article article = new Article();

		article.setId_article(rs.getInt(BStock.id_article));
		article.setNom_article(rs.getString(BStock.nom_article));
		article.setPrix_article(rs.getFloat(BStock.prix_article));
		article.setDelai_preparation(rs.getDouble(BStock.delai_preparation));
		
		
		commande.setId_cmd(rs.getInt(BCommande.id_cmd));
		commande.setQuantite(rs.getInt(BCommande.quantite));
		commande.setDateCommande(rs.getDate(BCommande.date_cmd));
		commande.setStock_moment_commande(rs.getInt(BCommande.stock_moment_commande));
		commande.setDelai_moment_commande(rs.getDouble(BCommande.delai_moment_commande));
		commande.setDelai_preparation_moment_commande(rs.getDouble(BCommande.delai_preparation_moment_commande));
		
		
		
		commande.setArticle(article);
		


		return commande;
	}
}