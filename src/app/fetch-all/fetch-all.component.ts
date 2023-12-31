import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TrainerService } from '../../trainer.service';
import { Trainer } from '../../trainer';
import { RouterLink, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fetch-all',
  standalone: true,
  imports: [CommonModule,RouterLink,RouterModule,FormsModule],
  templateUrl: './fetch-all.component.html',
  styleUrl: './fetch-all.component.css',
  providers: [TrainerService]

})
export class FetchAllComponent {
  allTrainers: Trainer[] = []; // Array to hold all trainers

  constructor(private trainerService: TrainerService) { }

  fetchAllTrainers(): void {
    this.trainerService.fetchAllTrainers().subscribe(
      (data: Trainer[]) => {
        this.allTrainers = data; // Assign received array of trainers
        console.log(this.allTrainers);
      },
      () => {
        this.allTrainers = []; // Handle error: Assign an empty array or handle differently
      }
    );
  }
}
