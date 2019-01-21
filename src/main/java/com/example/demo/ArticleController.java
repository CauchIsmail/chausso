package com.example.demo;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Article;
import com.service.article.ArticleDao;

@RestController
public class ArticleController {

	private static final Logger logger = LogManager.getLogger(ArticleController.class);
	private ClassPathXmlApplicationContext context;
	ArticleDao studentJDBCTemplate = null;

	@RequestMapping(value = "/getArticle", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Article> getArticle(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("appel au service getArticle");

		chargementContext();

		List<Article> listeArticle = null;
		try {
			listeArticle = studentJDBCTemplate.getListeArticle();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeArticle;

	}

	@RequestMapping(value = "/setArticle", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public List<Article> setArticle(@RequestBody List<Article> listeArticles) {

		chargementContext();

		List<Article> returnList = null;
		try {
			returnList = studentJDBCTemplate.setListeArticle(listeArticles);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnList;

	}

	private void chargementContext() {

		context = new ClassPathXmlApplicationContext("Beans.xml");
		studentJDBCTemplate = (ArticleDao) context.getBean("articleDao");

	}


}