import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FlexLayoutModule } from '@angular/flex-layout';

import { StockComponent } from './component/stock/stock.component';
import { ArticleComponent } from './component/article/article.component';
import { CommandeComponent } from './component/commande/commande.component';
import { EnteteComponent } from './component/entete/entete.component';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule } from '@angular/material/form-field';

import {MatBadgeModule} from '@angular/material/badge';

import {MatChipsModule} from '@angular/material/chips';
import {
  MatSelectModule,
  MatButtonModule
} from '@angular/material';

import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';

import { HttpService } from './service/HttpService';

import { MatDialogModule } from '@angular/material/dialog';
import { ModalConfirmationComponent } from './component/modal-confirmation/modal-confirmation.component';
import { ModalQuantiteCommandeComponent } from './component/modal-quantite-commande/modal-quantite-commande.component';
import {FormsModule} from '@angular/forms';

import {MatMenuModule} from '@angular/material/menu';
import {MatIconModule} from '@angular/material/icon';
import { AppRoutingModule } from './app-routing.module';
import { ModalArticleComponent } from './component/modal-article/modal-article.component';
import { ArticlePipe } from './pipe/ArticlePipe';





@NgModule({
  declarations: [
    AppComponent,
    StockComponent,
    ArticleComponent,
    CommandeComponent,
    EnteteComponent,
    ModalQuantiteCommandeComponent,
    ModalArticleComponent,
    ModalConfirmationComponent,
    ArticlePipe
  ],
  exports: [
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
    MatMenuModule,
    MatChipsModule,
    MatIconModule,
    MatBadgeModule
  ],
  entryComponents: [ModalQuantiteCommandeComponent,ModalConfirmationComponent,ModalArticleComponent] ,
  imports: [
    FormsModule,
    BrowserModule,
    MatInputModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatButtonModule,
    HttpModule,
    HttpClientModule,
    MatDialogModule,
    FlexLayoutModule,
    MatMenuModule,
    MatIconModule,
    MatChipsModule,
    AppRoutingModule,
    MatBadgeModule
    
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
