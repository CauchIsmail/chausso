package com.bdd.proprietes;

import java.util.ArrayList;
import java.util.Arrays;

public class BStock {

	public static String stock_table = "Stock";
	public static String article_table = "Article";
	public static String commande_table = "Commande";
	
	public static String id_article = "id_article";
	public static String id_cmd = "id_cmd";

	public static String prix_article = "prix_article";
	public static String delai_preparation = "delai_preparation";
	public static String quantite = "quantite";
	public static String date_cmd = "date_cmd";
	public static String qte_stock = "qte_stock";
	public static String delai = "delai";
	public static String nom_article = "nom_article";

	public static ArrayList<String> selectStock = new ArrayList<String>(
			Arrays.asList(article_table + "." + "id_article", "nom_article", "prix_article", "delai",qte_stock,delai_preparation));
	
	public static ArrayList<String> selectCommande = new ArrayList<String>(
			Arrays.asList(article_table + "." + "id_article", "nom_article", "prix_article", "date_cmd","delai_preparation",quantite,id_cmd,"stock_moment_commande","delai_moment_commande","delai_preparation_moment_commande"));

	public static ArrayList<String> jointureStockArticle = new ArrayList<String>(Arrays.asList(stock_table + "." + id_article, article_table + "." + id_article));

	public static ArrayList<String> jointureCommandeArticle = new ArrayList<String>(Arrays.asList(commande_table + "." + id_article, article_table + "." + id_article));

}
