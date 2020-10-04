import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayRawMaterialOrderComponent } from './display-raw-material-order.component';

describe('DisplayRawMaterialOrderComponent', () => {
  let component: DisplayRawMaterialOrderComponent;
  let fixture: ComponentFixture<DisplayRawMaterialOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayRawMaterialOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayRawMaterialOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
