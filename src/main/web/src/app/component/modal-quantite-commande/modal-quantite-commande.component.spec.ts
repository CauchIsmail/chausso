import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalQuantiteCommandeComponent } from './modal-quantite-commande.component';

describe('EnteteComponent', () => {
  let component: ModalQuantiteCommandeComponent;
  let fixture: ComponentFixture<ModalQuantiteCommandeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModalQuantiteCommandeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalQuantiteCommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
