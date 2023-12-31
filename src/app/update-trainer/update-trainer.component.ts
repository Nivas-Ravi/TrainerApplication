import { Component, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Trainer } from '../../trainer';
import { TrainerService } from '../../trainer.service';

@Component({
  selector: 'app-update-trainer',
  standalone: true,
  imports: [CommonModule,RouterLink,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,],
  templateUrl: './update-trainer.component.html',
  styleUrl: './update-trainer.component.css',
  providers: [TrainerService],
})
export class UpdateTrainerComponent {
  trainerUpdatedSuccessfully: boolean = false;
  notFound: boolean = false;
  id: number | undefined;
  trainerData: Trainer | null = null;
  model: Trainer = new Trainer();
  @ViewChild('trainerForm') trainerForm: any;
  constructor(private trainerService: TrainerService) {}

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

  submitForm(trainerForm: any): void {
    if (this.trainerForm.valid) {
      const trainerData = this.trainerForm.value;

      // Create the expected structure for trainer
      const formattedTrainerData = {
        trainerId: trainerData.trainerId,
        trainerName: trainerData.trainerName,
        trainerExperience: trainerData.trainerExperience,
        description: {
          descriptionId: trainerData.descriptionId,
        },
        city: {
          cityId: trainerData.cityId,
        },
        state: {
          stateId: trainerData.stateId,
        },
        country: {
          countryId: trainerData.countryId,
        },

        trainerNumber: trainerData.trainerNumber,
      };

      // Log the formatted trainer data
      console.log('Formatted trainer data:', formattedTrainerData);

      this.trainerService.updateTrainer(formattedTrainerData).subscribe(
        (response) => {
          console.log('Trainer updated successfully!', response);
          // Perform actions after successful addition
        },
        (error:any) => {
          if (error.status === 200) {
            this.trainerUpdatedSuccessfully = true;
            this.trainerForm.resetForm();
          }
          else{
            window.alert('Error adding Trainer. Please try again.');
          }
        }
      );
    }
  }
}
