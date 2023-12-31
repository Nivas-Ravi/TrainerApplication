
import { CommonModule } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { RouterLink, RouterModule } from '@angular/router';
import { TrainerService } from '../../trainer.service';
import { Trainer } from '../../trainer';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-addTrainer',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  templateUrl: './addTrainer.component.html',
  styleUrls: ['./addTrainer.component.css'],
  providers: [TrainerService],
})
export class AddTrainerComponent {
  trainerAddedSuccessfully: boolean = false;
  model: Trainer = new Trainer();
  @ViewChild('trainerForm') trainerForm: any;
  constructor(private trainerService: TrainerService) {}

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

      this.trainerService.addTrainer(formattedTrainerData).subscribe(
        (response: any) => {
          console.log('Trainer added successfully!', response);

          window.alert('Trainer added successfully');
          this.trainerForm.resetForm();
          // Perform actions after successful addition
        },
        (error:any) => {
          if (error.status === 200) {
            this.trainerAddedSuccessfully = true; // Set the flag to true upon success
            this.trainerForm.resetForm();
          } else {
            // Show an alert box for other error cases
            window.alert('Error adding Trainer. Please try again.');

          }
        }
      );
    }
  }
}


