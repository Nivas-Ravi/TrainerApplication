import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TrainerService } from '../../trainer.service';
import { RouterLink, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-trainer-in-each-city',
  standalone: true,
  imports: [CommonModule,RouterLink,
    RouterModule,
    FormsModule,
    ],
  templateUrl: './trainer-in-each-city.component.html',
  styleUrl: './trainer-in-each-city.component.css',
  providers: [TrainerService],
})
export class TrainerInEachCityComponent{

  allTrainers: any[] = []; // Fetch all trainers and store here
  trainersWithMaxExperience: any[] = []; // Store trainers with max experience per city

  constructor(private trainerService: TrainerService) { }

  fetchAllTrainers(): void {
    // Call findAll to fetch all trainers
    this.trainerService.fetchAllTrainers().subscribe(
      (data: any[]) => {
        this.allTrainers = data;
        this.filterTrainersWithMaxExperiencePerCity();
      },
      (error) => {
        console.error('Error fetching trainers', error);
      }
    );
  }

  filterTrainersWithMaxExperiencePerCity(): void {
    const trainersByCity: Map<string, any[]> = new Map<string, any[]>(); // Map to hold trainers per city

    // Loop through all trainers and organize them by city
    this.allTrainers.forEach(trainer => {
      const city = trainer.city.cityName; // Assuming cityName is the key for cities

      if (!trainersByCity.has(city)) {
        trainersByCity.set(city, []);
      }

      const trainersInCity = trainersByCity.get(city);
      if (trainersInCity) {
        trainersInCity.push(trainer);
      }
    });

    // Find trainers with max experience for each city
    trainersByCity.forEach((trainers, city) => {
      const maxExperienceTrainer = trainers.reduce((prev, current) => {
        return (prev.trainerExperience > current.trainerExperience) ? prev : current;
      });
      this.trainersWithMaxExperience.push(maxExperienceTrainer);
    });
  }
}


