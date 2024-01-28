import { HomeComponent } from './home/home.component';
import { Component, ɵgetHostElement } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddTrainerComponent } from './addTrainer/addTrainer.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { FetchTrainerByIdComponent } from './fetch-trainer-by-id/fetch-trainer-by-id.component';
import { FetchAllComponent } from './fetch-all/fetch-all.component';
import { UpdateTrainerComponent } from './update-trainer/update-trainer.component';
import { TrainerInEachCityComponent } from './trainer-in-each-city/trainer-in-each-city.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule,
    RouterOutlet,
    HomeComponent,
    RouterModule,
    FormsModule,
    AddTrainerComponent,
    LoginComponent,
    FetchTrainerByIdComponent,
    FetchAllComponent,
    HttpClientModule,UpdateTrainerComponent,TrainerInEachCityComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Trainer';
}
