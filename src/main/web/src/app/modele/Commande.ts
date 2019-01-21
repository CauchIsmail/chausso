import { Article } from "./Article";

export class Commande{


    public  id_cmd:number;
	public  article:Article;
	public  quantite:number;
	public  dateCommande:string;
	public  stock_moment_commande:number;
	public delai_moment_commande:number;
	public delai_preparation_moment_commande:number;

	
}


