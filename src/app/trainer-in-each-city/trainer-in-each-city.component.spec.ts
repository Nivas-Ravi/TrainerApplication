import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerInEachCityComponent } from './trainer-in-each-city.component';

describe('TrainerInEachCityComponent', () => {
  let component: TrainerInEachCityComponent;
  let fixture: ComponentFixture<TrainerInEachCityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrainerInEachCityComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TrainerInEachCityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
