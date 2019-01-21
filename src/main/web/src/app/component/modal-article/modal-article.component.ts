import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Commande } from '../../modele/Commande';
import { Article } from 'src/app/modele/Article';

@Component({
  selector: 'app-modal-article',
  templateUrl: './modal-article.component.html',
  styleUrls: ['./modal-article.component.css']
})
export class ModalArticleComponent {

  article: any;

  constructor(
    public dialogRef: MatDialogRef<ModalArticleComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {

    if (this.data.article != null) {
      this.article = this.data.article;
    }else{
         this.article = {
        id_article: null,
        nom_article: "",
        prix_article: null,
        delai_preparation: null
      } 
    }



  }

  ajouter(): void {
    this.article.modifie = true;
    this.dialogRef.close(this.article);
  }



}