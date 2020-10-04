import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplaySupplierDetailsComponent } from './display-supplier-details.component';

describe('DisplaySupplierDetailsComponent', () => {
  let component: DisplaySupplierDetailsComponent;
  let fixture: ComponentFixture<DisplaySupplierDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplaySupplierDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplaySupplierDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
