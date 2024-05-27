import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SkLanguages } from '../../models/SkLanguages/sk-languages';

@Injectable({
  providedIn: 'root'
})
export class SkLanguagesService {
  private apiUrl = 'http://localhost:8080/empleado/skLenguage';
  constructor(private http: HttpClient) { }

  getAll(): Observable<SkLanguages[]> {
    return this.http.get<SkLanguages[]>(this.apiUrl);
  }

  getById(id: number): Observable<SkLanguages> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<SkLanguages>(url);
  }

  // create(skLanguage: SkLanguages): Observable<SkLanguages> {
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post<SkLanguages>(this.apiUrl, skLanguage, { headers });
  // }

  // update(skLanguage: SkLanguages): Observable<SkLanguages> {
  //   const url = `${this.apiUrl}/${skLanguage.id_sklanguage}`;
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.put<SkLanguages>(url, skLanguage, { headers });
  // }

  // delete(id: number): Observable<void> {
  //   const url = `${this.apiUrl}/${id}`;
  //   return this.http.delete<void>(url);
  // }
}
