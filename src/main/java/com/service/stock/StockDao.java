package com.service.stock;

import com.bdd.proprietes.BStock;
import com.model.Article;
import com.model.Stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class StockDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private SimpleJdbcInsert insertActor;

	public List<Stock> getListeStock() throws SQLException, FileNotFoundException, IOException {

	

		String sql = "SELECT " + String.join(",", BStock.selectStock) + " FROM " + BStock.stock_table + ","
				+ BStock.article_table + " where " + String.join("=", BStock.jointureStockArticle);

		List<Stock> listeStock = jdbcTemplateObject.query(sql, new StockRowMapper());

		return listeStock;

	}
	
	public List<Stock> getListeStockFromFichier() throws SQLException, FileNotFoundException, IOException {

		return this.getListeAnomalies();


	}

	public List<Stock> setListeStock(List<Stock> listeStock) throws SQLException {
		for (Stock anomalie : listeStock) {

			Map<String, Object> parameters = new HashMap<String, Object>(3);

			parameters.put(BStock.qte_stock, anomalie.getStock());
			parameters.put(BStock.id_article, anomalie.getArticle().getId_article());
			parameters.put(BStock.delai, anomalie.getDelai());

			insertActor.execute(parameters);
		}

		return listeStock;

	}

	public void setDataSource(javax.sql.DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("Stock");
	}

	private String csvFile = "/Users/ismaillmaouli/Desktop/file.csv";

	Pattern pattern = Pattern.compile(";");

	public List<Stock> getListeAnomalies() throws SQLException, FileNotFoundException, IOException {

		try (BufferedReader in = new BufferedReader(new FileReader(csvFile));) {
			List<Stock> players = in.lines().skip(1).map(line -> {
				String[] x = pattern.split(line);

				float prixArticle = 0;
				String nomArticle = null;
				int idArticle = 0;
				
				int stock = 0;
				double delai = 0;

				if (x.length != 0) {
					idArticle = Integer.parseInt(x[0]);
					nomArticle = x[1];
					prixArticle = Float.parseFloat(x[2]);
					
					stock = Integer.parseInt(x[3]);
					
					delai  = Double.parseDouble(x[4]);
					
					
					
				}

				return new Stock(new Article(idArticle, nomArticle, prixArticle),
						stock, delai);

			}).collect(Collectors.toList());

			return players;
		}

	}

}
