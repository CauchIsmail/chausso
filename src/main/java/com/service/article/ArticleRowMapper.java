package com.service.article;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.bdd.proprietes.*;
import com.model.Article;


public class ArticleRowMapper implements RowMapper<Article> {
	public Article mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Article stock = new Article();

		
		stock.setId_article(rs.getInt(BStock.id_article));
		stock.setNom_article(rs.getString(BStock.nom_article));
		stock.setPrix_article(rs.getFloat(BStock.prix_article));
		stock.setDelai_preparation(rs.getDouble(BStock.delai_preparation));


		return stock;
	}
}