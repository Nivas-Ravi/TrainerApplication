import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,RouterLink,RouterModule,FormsModule,ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

model: any = {}; // Object to bind form data

  Submit(form: any) {
    if (form.valid) {
      console.log('Form Submitted', this.model);
      // Perform actions with the submitted form data
    } else {
      console.log('Invalid form');
      // Handle invalid form submission
    }

  }

}
