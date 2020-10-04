import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayDistributorDetailsComponent } from './display-distributor-details.component';

describe('DisplayDistributorDetailsComponent', () => {
  let component: DisplayDistributorDetailsComponent;
  let fixture: ComponentFixture<DisplayDistributorDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayDistributorDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayDistributorDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
