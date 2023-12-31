import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchTrainerByIdComponent } from './fetch-trainer-by-id.component';

describe('FetchTrainerByIdComponent', () => {
  let component: FetchTrainerByIdComponent;
  let fixture: ComponentFixture<FetchTrainerByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FetchTrainerByIdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FetchTrainerByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
