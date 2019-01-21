package com.service.stock;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.bdd.proprietes.BStock;
import com.model.Article;
import com.model.Stock;


public class StockRowMapper implements RowMapper<Stock> {
	public Stock mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Stock stock = new Stock();
		Article article = new Article();
		stock.setStock(rs.getInt(BStock.qte_stock));
		
		
		article.setId_article(rs.getInt(BStock.id_article));
		article.setNom_article(rs.getString(BStock.nom_article));
		article.setPrix_article(rs.getFloat(BStock.prix_article));
		article.setDelai_preparation(rs.getDouble(BStock.delai_preparation));
		
		stock.setArticle(article);
		stock.setDelai(rs.getDouble(BStock.delai));
		
		
		

		return stock;
	}
}