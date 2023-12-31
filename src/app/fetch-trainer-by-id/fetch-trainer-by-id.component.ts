import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { TrainerService } from '../../trainer.service';
import { Trainer } from '../../trainer';

@Component({
  selector: 'app-fetch-trainer-by-id',
  standalone: true,
  imports: [CommonModule,RouterLink,
    RouterModule,
    FormsModule,],
  templateUrl: './fetch-trainer-by-id.component.html',
  styleUrl: './fetch-trainer-by-id.component.css',
  providers: [TrainerService],
})
export class FetchTrainerByIdComponent {
  notFound: boolean = false;
  id: number | undefined;
  trainerData: Trainer | null = null;

  constructor(private trainerService: TrainerService) { }

  fetchTrainerById(): void {
    this.trainerService.fetchTrainerById(this.id).subscribe(
      (data: Trainer) => {
        this.trainerData = data;
        console.log(this.trainerData);
      },
      (error) => {
        if (error.status === 404) {
          this.notFound = true;
        }
      }
    );
  }

  resetNotFoundFlag(): void {
    this.notFound = false;
  }

}
