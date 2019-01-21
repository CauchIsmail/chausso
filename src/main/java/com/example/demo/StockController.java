package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
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

import com.model.Stock;
import com.service.stock.StockDao;

@RestController
public class StockController {

	private static final Logger logger = LogManager.getLogger(StockController.class);
	private ApplicationContext context;
	StockDao studentJDBCTemplate = null;

	@RequestMapping(value = "/getStock", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Stock> getStock(@RequestParam(value = "name", defaultValue = "World") String name) throws FileNotFoundException, IOException {
		logger.info("appel au service getStock");

		chargementContext();

		List<Stock> listeStock = null;
		try {
			listeStock = studentJDBCTemplate.getListeStock();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeStock;

	}
	
	@RequestMapping(value = "/getStockFromFichier", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Stock> getStockFromFichier(@RequestParam(value = "name", defaultValue = "World") String name) throws FileNotFoundException, IOException {
		logger.info("appel au service getStock");

		chargementContext();

		List<Stock> listeStock = null;
		try {
			listeStock = studentJDBCTemplate.getListeStockFromFichier();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeStock;

	}

	@RequestMapping(value = "/setStock", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public List<Stock> setStock(@RequestBody List<Stock> listeStocks) {

		chargementContext();

		List<Stock> returnList = null;
		try {
			returnList = studentJDBCTemplate.setListeStock(listeStocks);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnList;

	}

	private void chargementContext() {

		context = new ClassPathXmlApplicationContext("Beans.xml");
		studentJDBCTemplate = (StockDao) context.getBean("stockDao");

	}




}