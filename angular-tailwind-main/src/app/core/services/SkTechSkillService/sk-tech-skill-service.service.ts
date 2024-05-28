import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SkTechSkill } from '../../models/SkTechSkill/sk-tech-skill';


@Injectable({
  providedIn: 'root'
})
export class SkTechSkillService {
  private apiUrl = 'http://localhost:8080/empleado/sk_techskills';

  constructor(private http: HttpClient) { }

  getAll(): Observable<SkTechSkill[]> {
    return this.http.get<SkTechSkill[]>(this.apiUrl);
  }

  getById(id: number): Observable<SkTechSkill> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<SkTechSkill>(url);
  }

  // create(skTechSkill: SkTechSkill): Observable<SkTechSkill> {
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post<SkTechSkill>(this.apiUrl, skTechSkill, { headers });
  // }

  // update(skTechSkill: SkTechSkill): Observable<SkTechSkill> {
  //   const url = `${this.apiUrl}/${skTechSkill.idSkTechSkill}`;
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.put<SkTechSkill>(url, skTechSkill, { headers });
  // }

  // delete(id: number): Observable<void> {
  //   const url = `${this.apiUrl}/${id}`;
  //   return this.http.delete<void>(url);
  // }
}
