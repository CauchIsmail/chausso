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

import com.model.Commande;
import com.service.commande.CommandeDao;

@RestController
public class CommandeController {

	private static final Logger logger = LogManager.getLogger(CommandeController.class);
	private ApplicationContext context;
	CommandeDao studentJDBCTemplate = null;

	@RequestMapping(value = "/getCommande", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public List<Commande> getCommande(@RequestParam(value = "name", defaultValue = "World") String name) {
		logger.info("appel au service getCommande");

		chargementContext();

		List<Commande> listeCommande = null;
		try {
			listeCommande = studentJDBCTemplate.getListeCommande();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeCommande;

	}

	@RequestMapping(value = "/setCommande", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public List<Commande> setCommande(@RequestBody List<Commande> listeCommandes) {

		chargementContext();

		List<Commande> returnList = null;
		try {
			returnList = studentJDBCTemplate.setListeCommande(listeCommandes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnList;

	}

	private void chargementContext() {

		context = new ClassPathXmlApplicationContext("Beans.xml");
		studentJDBCTemplate = (CommandeDao) context.getBean("commandeDao");

	}

//	@RequestMapping(value = "/getAirport", method = RequestMethod.GET)
//	@CrossOrigin(origins = "*")
//	public List<Airport> getAirport(@RequestParam(value = "name", defaultValue = "World") String name) throws FileNotFoundException, IOException {
//		logger.info("appel au service getAirport");
//		logger.debug("appel au service getAirport");
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/example/demo/Beans.xml");
//		AirportDao studentJDBCTemplate = (AirportDao) context.getBean("airportDao");
//		List<Airport> listeCommande = null;
//		try {
//			listeCommande = studentJDBCTemplate.getListeCommandes();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return listeCommande;
//
//	}

}