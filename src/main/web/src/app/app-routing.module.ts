import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { CommandeComponent } from './component/commande/commande.component';
import { StockComponent } from './component/stock/stock.component';
import { ArticleComponent } from './component/article/article.component';

const routes: Routes = [
  { path: '', redirectTo: '/stock', pathMatch: 'full' },
  { path: 'commandes', component: CommandeComponent },
  { path: 'articles', component: ArticleComponent },
  { path: 'stock', component: StockComponent }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})





export class AppRoutingModule {


}
