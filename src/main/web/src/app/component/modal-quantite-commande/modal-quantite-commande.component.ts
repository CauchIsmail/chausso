import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Commande } from '../../modele/Commande';
import { Article } from 'src/app/modele/Article';

@Component({
  selector: 'app-modal-quantite-commande',
  templateUrl: './modal-quantite-commande.component.html',
  styleUrls: ['./modal-quantite-commande.component.css']
})
export class ModalQuantiteCommandeComponent {

  commande: Commande;
  article: Article;

  constructor(
    public dialogRef: MatDialogRef<ModalQuantiteCommandeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {


    this.commande = {
      id_cmd: null,
      article: this.data.stock.article,
      quantite: this.data.stock.quantiteCommandee,
      dateCommande: "",
      stock_moment_commande: this.data.stock.stock,
      delai_moment_commande:this.data.stock.delai,
      delai_preparation_moment_commande:this.data.stock.article.delai_preparation
    }

  }

  ajouter(): void {
    this.dialogRef.close(this.commande);
  }



}
