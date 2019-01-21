import { Pipe, PipeTransform } from '@angular/core';


@Pipe({ name: 'articlePipe' })
export class ArticlePipe implements PipeTransform {
  transform(allArticles: any[],arg1) {
    if(allArticles!=undefined && arg1 != undefined){
    return allArticles.filter(article => article.article.nom_article.toUpperCase().indexOf(arg1.toUpperCase())>-1);
    }else{
      return allArticles;
    }
  }
}