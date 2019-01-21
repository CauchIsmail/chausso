import { Component, OnInit } from '@angular/core';
import { Commande } from '../../modele/Commande';
import { HttpService } from '../../service/HttpService';
import { Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material';
import { ModalQuantiteCommandeComponent } from '../modal-quantite-commande/modal-quantite-commande.component';
import { ModalConfirmationComponent } from '../modal-confirmation/modal-confirmation.component';
import { MatIconModule } from '@angular/material/icon';


import * as jspdf from 'jspdf';



@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {





  eanRecherche: string;
  listeCommandeChausson: Commande[];
  listeCommandesChausson: Commande[];
  listeCommandeBdd: Commande[] = [];
  date: Date;
  constructor(private httpService: HttpService,
    public dialog: MatDialog) { }

  ngOnInit() {
    this.getListeCommande();
    this.listeCommandesChausson = [];
  }








  getListeCommande() {
    this.httpService.get("http://localhost:8080/chausso-0.0.1-SNAPSHOT/getCommande")
      .subscribe(
        data => {
          this.listeCommandeChausson = data[0];
          console.log(this.listeCommandeChausson);

          this.listeCommandeChausson.forEach((commande:any) => {
            commande.sous = commande.stock_moment_commande - commande.quantite;
            this.date = new Date(commande.dateCommande);
            commande.dateLivraison = this.date.setDate(this.date.getDate() + commande.delai_moment_commande);

            console.log(commande.dateLivraison);

            if (commande.sous < 0) {
              commande.quantiteNor = commande.quantite + commande.sous;
              commande.sous = Math.abs(commande.sous);
              commande.dateLivraisonPreparation = this.date.setDate(this.date.getDate() + commande.delai_preparation_moment_commande + commande.delai_moment_commande);
            }else{
              commande.quantiteNor = commande.quantite
            }
          });


        }

      );
  }






}
