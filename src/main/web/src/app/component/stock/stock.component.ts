import { Component, OnInit } from '@angular/core';
import { Stock } from '../../modele/Stock';
import { HttpService } from '../../service/HttpService';
import { Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material';
import { ModalQuantiteCommandeComponent } from '../modal-quantite-commande/modal-quantite-commande.component';
import { ModalConfirmationComponent } from '../modal-confirmation/modal-confirmation.component';
import { MatIconModule } from '@angular/material/icon';
import { Commande } from 'src/app/modele/Commande';


import * as jspdf from 'jspdf';
//import html2canvas from 'html2canvas';



@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {


  pourBadge:number;




  eanRecherche: string;
  listeStockChausson: Stock[];
  listeCommandesChausson: Commande[];
  listeStockBdd: Stock[] = [];
  constructor(private httpService: HttpService,
    public dialog: MatDialog) { }

  ngOnInit() {

    this.pourBadge = 0;
    this.getListeStock();
    this.listeCommandesChausson = [];
  }


  creer() {

  }


  enregistrer() {


    const dialogRef = this.dialog.open(ModalConfirmationComponent, {
      width: '250px',
      data: {
        message: "Voulez-vous vraiment envoyer cette commande ?",
        ouiNon: true
      }
    });




    dialogRef.afterClosed().subscribe(result => {

      if (result) {
        this.httpService.post("http://localhost:8080/chausso-0.0.1-SNAPSHOT/setCommande", this.listeCommandesChausson)
          .subscribe(
            data => {
              console.log(this.listeStockChausson);
              this.getListeStock();

              const dialogRefOk = this.dialog.open(ModalConfirmationComponent, {
                width: '250px',
                data: {
                  message: "Commande envoyée avec succée",
                  ouiNon: false
                }
              });



            }
          );

      }

    });


  }




  getListeStock() {
    this.httpService.get("http://localhost:8080/chausso-0.0.1-SNAPSHOT/getStock")
      .subscribe(
        data => {
          this.listeStockChausson = data[0];
          console.log(this.listeStockChausson);
        }

      );
  }

  openDialog(stock: any) {


    const dialogRef = this.dialog.open(ModalQuantiteCommandeComponent, {
      width: '250px',
      data: { stock: stock }
    });

    dialogRef.afterClosed().subscribe(result => {

      if (result != null) {
        stock.quantiteCommandee = result.quantite;


        let index: number = this.listeCommandesChausson.indexOf(this.listeCommandesChausson.find(cmd => cmd.article.id_article == result.article.id_article));
        if (index == -1) {
          if (result.quantite > 0) {
            this.listeCommandesChausson.push(result);
          }
        } else {
          this.listeCommandesChausson.splice(index, 1);
          this.pourBadge -=result.quantite;
          if (result.quantite > 0) {
            
            this.listeCommandesChausson.push(result);
          }
        }

        this.pourBadge = 0;
        this.listeCommandesChausson.forEach(cmd=>{
          this.pourBadge +=cmd.quantite;
        });

        console.log(this.listeCommandesChausson);

      }

    });

  }




}
