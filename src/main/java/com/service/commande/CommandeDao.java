package com.service.commande;

import com.bdd.proprietes.BCommande;
import com.bdd.proprietes.BStock;
import com.model.Commande;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class CommandeDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private SimpleJdbcInsert insertActor;

	public List<Commande> getListeCommande() throws SQLException {

		String sql = "SELECT " + String.join(",", BStock.selectCommande) + " FROM " + BStock.commande_table + ","
				+ BStock.article_table + " where " + String.join("=", BStock.jointureCommandeArticle);
		
		List<Commande> listeCommande = jdbcTemplateObject.query(sql, new CommandeRowMapper());

		return listeCommande;

	}
	
	


	public List<Commande> setListeCommande(List<Commande> listeCommande) throws SQLException {
		
		LocalDate localDate = LocalDate.now();

        String currentDate = DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate);
		
		for (Commande commande : listeCommande) {

			Map<String, Object> parameters = new HashMap<String, Object>(3);

			parameters.put(BCommande.quantite, commande.getQuantite());
			parameters.put(BCommande.date_cmd, currentDate);
			
			parameters.put(BCommande.stock_moment_commande, commande.getStock_moment_commande());
			parameters.put(BCommande.delai_moment_commande, commande.getDelai_moment_commande());
			parameters.put(BCommande.delai_preparation_moment_commande, commande.getDelai_preparation_moment_commande());
			
			parameters.put(BCommande.id_article, commande.getArticle().getId_article());

			insertActor.execute(parameters);
		}

		return listeCommande;

	}

	public void setDataSource(javax.sql.DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("Commande");
	}

}
