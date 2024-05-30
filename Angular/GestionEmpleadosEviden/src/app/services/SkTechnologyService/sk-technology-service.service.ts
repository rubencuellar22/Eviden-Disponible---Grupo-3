import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'; 
import { SkTechnology } from '../../classes/SkTechnology/sk-technology';

@Injectable({
  providedIn: 'root'
})
export class SkTechnologyService {
  private apiUrl = 'http://localhost:8080/empleado/sk_technology/technology/'; 

  constructor(private http: HttpClient) { }

  getAll(): Observable<SkTechnology[]> {
    return this.http.get<SkTechnology[]>(this.apiUrl);
  }

  getById(id: number): Observable<SkTechnology> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<SkTechnology>(url);
  }

  // create(skTechnology: SkTechnology): Observable<SkTechnology> {
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post<SkTechnology>(this.apiUrl, skTechnology, { headers });
  // }

  // update(skTechnology: SkTechnology): Observable<SkTechnology> {
  //   const url = `${this.apiUrl}/${skTechnology.id}`;
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.put<SkTechnology>(url, skTechnology, { headers });
  // }

  // delete(id: number): Observable<void> {
  //   const url = `${this.apiUrl}/${id}`;
  //   return this.http.delete<void>(url);
  // }
}
