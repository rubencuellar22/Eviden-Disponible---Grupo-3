import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SkBusSkills } from '../../classes/SkBusSkill/sk-bus-skill';

@Injectable({
  providedIn: 'root'
})
export class SkBusSkillService {
  private apiUrl = 'http://localhost:8080/empleado/skBussskill/';
  constructor(private http: HttpClient) {}

  getSkBusSkills(): Observable<SkBusSkills[]> {
    return this.http.get<SkBusSkills[]>(this.apiUrl);
  }

  getSkBusSkillById(id: number): Observable<SkBusSkills> {
    return this.http.get<SkBusSkills>(`${this.apiUrl}/${id}`);
  }

  // createSkBusSkill(skBusSkill: SkBusSkill): Observable<SkBusSkill> {
  //   return this.http.post<SkBusSkill>(this.apiUrl, skBusSkill);
  // }

  // updateSkBusSkill(id: number, skBusSkill: SkBusSkill): Observable<SkBusSkill> {
  //   return this.http.put<SkBusSkill>(`${this.apiUrl}/${id}`, skBusSkill);
  // }

  // deleteSkBusSkill(id: number): Observable<void> {
  //   return this.http.delete<void>(`${this.apiUrl}/${id}`);
  // }
}