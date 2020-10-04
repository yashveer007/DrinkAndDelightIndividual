import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayProductOrderComponent } from './display-product-order.component';

describe('DisplayProductOrderComponent', () => {
  let component: DisplayProductOrderComponent;
  let fixture: ComponentFixture<DisplayProductOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayProductOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayProductOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
