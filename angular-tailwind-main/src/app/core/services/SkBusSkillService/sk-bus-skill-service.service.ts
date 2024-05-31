import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SkBusSkills } from '../../models/SkBusSkill/sk-bus-skill';  // Asegúrate de que el nombre importado es correcto

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

  // createSkBusSkill(skBusSkill: SkBusSkills): Observable<SkBusSkills> {
  //   return this.http.post<SkBusSkills>(this.apiUrl, skBusSkill);
  // }

  // updateSkBusSkill(id: number, skBusSkill: SkBusSkills): Observable<SkBusSkills> {
  //   return this.http.put<SkBusSkills>(`${this.apiUrl}/${id}`, skBusSkill);
  // }

  // deleteSkBusSkill(id: number): Observable<void> {
  //   return this.http.delete<void>(`${this.apiUrl}/${id}`);
  // }
}
