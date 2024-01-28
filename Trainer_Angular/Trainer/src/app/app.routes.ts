import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AddTrainerComponent } from './addTrainer/addTrainer.component';
import { LoginComponent } from './login/login.component';
import { FetchTrainerByIdComponent } from './fetch-trainer-by-id/fetch-trainer-by-id.component';
import { FetchAllComponent } from './fetch-all/fetch-all.component';
import { UpdateTrainerComponent } from './update-trainer/update-trainer.component';
import { TrainerInEachCityComponent } from './trainer-in-each-city/trainer-in-each-city.component';


export const routes: Routes = [
    { path:'home',component:HomeComponent},
    {path:'login',component:LoginComponent},
    {path:'addTrainer',component:AddTrainerComponent},
    {path:'fetch-trainer-by-id',component:FetchTrainerByIdComponent},
    {path:'fetch-all',component:FetchAllComponent},
    {path:'update-trainer',component:UpdateTrainerComponent},
    {path:'trainer-in-each-city',component:TrainerInEachCityComponent},
    {path:'',redirectTo:'/home',pathMatch:'full'},

];
