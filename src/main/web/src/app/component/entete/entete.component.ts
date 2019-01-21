import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-entete',
  templateUrl: './entete.component.html',
  styleUrls: ['./entete.component.css']
})
export class EnteteComponent implements OnInit {

  currentPage:string;



  constructor() { this.currentPage = "Stock"; }

  ngOnInit() {
  }

}
