 import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Trainer } from './trainer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {



  private apiUrl='http://localhost:8080';
  private fetchByIdUrl = 'http://localhost:8080/fetchTrainerById';
  private fetchAllUrl = 'http://localhost:8080/fetchAllTrainers';
  private updateUrl='http://localhost:8080/updateTrainer';

  constructor(private http:HttpClient){}

  addTrainer(trainer: Trainer): Observable<Trainer> {
    return this.http.post<Trainer>(`${this.apiUrl}/addTrainer`, trainer);
  }

  fetchTrainerById(trainerId:any):Observable<any>{
    return this.http.get<any>(this.fetchByIdUrl,{params:{trainerId}});
  }

  fetchAllTrainers(): Observable<any> {
    return this.http.get<any>(`${this.fetchAllUrl}`);
  }

  updateTrainer(trainer:Trainer):Observable<Trainer>
  {
    return this.http.post<Trainer>(`${this.updateUrl}`, trainer);
  }
}
