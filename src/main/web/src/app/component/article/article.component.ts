import { Component, OnInit } from '@angular/core';
import { Article } from '../../modele/Article';
import { HttpService } from '../../service/HttpService';
import { Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material';
import { ModalQuantiteCommandeComponent } from '../modal-quantite-commande/modal-quantite-commande.component';
import { ModalConfirmationComponent } from '../modal-confirmation/modal-confirmation.component';
import { MatIconModule } from '@angular/material/icon';
import { Commande } from 'src/app/modele/Commande';
import { ModalArticleComponent } from '../modal-article/modal-article.component';





@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {



  eanRecherche: string;
  listeArticles: Article[];
  listeArticlesAEnvoyer: Article[];
  listeCommandesChausson: Commande[];
  listeArticleBdd: Article[] = [];
  gen_id: number = 0;
  constructor(private httpService: HttpService,
    public dialog: MatDialog) { }

  ngOnInit() {
    this.getListeArticle();
    this.listeArticlesAEnvoyer = [];
    this.listeCommandesChausson = [];
  }


  creer() {

  }





  enregistrer() {


    const dialogRef = this.dialog.open(ModalConfirmationComponent, {
      width: '250px',
      data: {
        message: "Voulez-vous vraiment enregistrer ?",
        ouiNon: true
      }
    });




    dialogRef.afterClosed().subscribe(result => {

      if (result) {
        this.listeArticlesAEnvoyer.forEach(art => {
          if (art.id_article < 0) {
            art.id_article = null;
          }
        });
        this.httpService.post("http://localhost:8080/chausso-0.0.1-SNAPSHOT/setArticle", this.listeArticlesAEnvoyer)
          .subscribe(
            data => {

              this.listeArticlesAEnvoyer = [];
              console.log(this.listeArticles);
              this.getListeArticle();

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




  getListeArticle() {
    this.httpService.get("http://localhost:8080/chausso-0.0.1-SNAPSHOT/getArticle")
      .subscribe(
        data => {
          this.listeArticles = data[0];
          console.log(this.listeArticles);
        }

      );
  }

  openDialog(article: any) {

    this.gen_id--;


    const dialogRef = this.dialog.open(ModalArticleComponent, {
      width: '250px',
      data: { article: article }
    });

    dialogRef.afterClosed().subscribe(result => {

      if (result != null) {
        if (result.id_article == null) {
          result.id_article = this.gen_id;
          this.listeArticles.push(result);
          this.listeArticlesAEnvoyer.push(result);
        } else {
          let index: number = this.listeArticles.indexOf(this.listeArticles.find(art => art.id_article == result.id_article));
          let indexEnv: number = this.listeArticlesAEnvoyer.indexOf(this.listeArticlesAEnvoyer.find(art => art.id_article == result.id_article));
           // this.listeArticles.splice(index, 1);
          this.listeArticlesAEnvoyer.splice(indexEnv, 1);
          this.listeArticlesAEnvoyer.push(result);
        }
      }

    });

  }




}
