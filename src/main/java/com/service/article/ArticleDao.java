package com.service.article;

import com.bdd.proprietes.*;
import com.bdd.proprietes.BStock;
import com.model.Article;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class ArticleDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private SimpleJdbcInsert insertActor;

	public List<Article> getListeArticle() throws SQLException {

		String sql = "SELECT " + "*" + " FROM " + BStock.article_table;

		List<Article> listeArticle = jdbcTemplateObject.query(sql, new ArticleRowMapper());

		return listeArticle;

	}

	public List<Article> setListeArticle(List<Article> listeArticle) throws SQLException {

		for (Article article : listeArticle) {

			Map<String, Object> parameters = new HashMap<String, Object>(3);

			parameters.put(BStock.id_article, article.getId_article());
			parameters.put(BStock.nom_article, article.getNom_article());
			parameters.put(BStock.prix_article, article.getPrix_article());
			parameters.put(BStock.delai_preparation, article.getDelai_preparation());

			if (article.getId_article() == 0) {
				insertActor.execute(parameters);
			} else {
				setName(article);
			}
		}

		return listeArticle;

	}

	public void setName(Article article) {

		String updateQuery = "update article set nom_article = ? , prix_article = ? , delai_preparation = ? where id_article = ?";
		jdbcTemplateObject.update(updateQuery, article.getNom_article(), article.getPrix_article(),
				article.getDelai_preparation(), article.getId_article());

	}

	public void setDataSource(javax.sql.DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		this.insertActor = new SimpleJdbcInsert(dataSource).withTableName("Article");
	}

}
