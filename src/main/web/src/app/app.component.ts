import { Component } from '@angular/core';
import { MatIconRegistry } from "@angular/material/icon";
import { DomSanitizer } from "@angular/platform-browser";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';

  constructor(
    private matIconRegistry: MatIconRegistry,
    private domSanitizer: DomSanitizer
  ){
    this.matIconRegistry.addSvgIcon(
      "more",
      this.domSanitizer.bypassSecurityTrustResourceUrl("../chausso-0.0.1-SNAPSHOT/assets/icons/more.svg")
    );

    this.matIconRegistry.addSvgIcon(
      "stock",
      this.domSanitizer.bypassSecurityTrustResourceUrl("../chausso-0.0.1-SNAPSHOT/assets/icons/stock.svg")
    );

    this.matIconRegistry.addSvgIcon(
      "commande",
      this.domSanitizer.bypassSecurityTrustResourceUrl("../chausso-0.0.1-SNAPSHOT/assets/icons/commande.svg")
    );

    this.matIconRegistry.addSvgIcon(
      "chaussure",
      this.domSanitizer.bypassSecurityTrustResourceUrl("../chausso-0.0.1-SNAPSHOT/assets/icons/chaussure.svg")
    );

    this.matIconRegistry.addSvgIcon(
      "add",
      this.domSanitizer.bypassSecurityTrustResourceUrl("../chausso-0.0.1-SNAPSHOT/assets/icons/add.svg")
    );
  }


}
