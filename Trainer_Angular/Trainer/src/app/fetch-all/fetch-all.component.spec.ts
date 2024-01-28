import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchAllComponent } from './fetch-all.component';

describe('FetchAllComponent', () => {
  let component: FetchAllComponent;
  let fixture: ComponentFixture<FetchAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FetchAllComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FetchAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});