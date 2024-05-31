import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SkMethod } from '../../models/SkMethod/sk-method';

@Injectable({
  providedIn: 'root'
})
export class SkMethodService {
  private apiUrl = 'http://localhost:8080/empleado/skMethod/'

  constructor(private http: HttpClient) { }

  getAll(): Observable<SkMethod[]> {
    return this.http.get<SkMethod[]>(this.apiUrl);
  }

  getById(id: number): Observable<SkMethod> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<SkMethod>(url);
  }

  // create(skMethod: SkMethod): Observable<SkMethod> {
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post<SkMethod>(this.apiUrl, skMethod, { headers });
  // }

  // update(skMethod: SkMethod): Observable<SkMethod> {
  //   const url = `${this.apiUrl}/${skMethod.id_skmethod}`;
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.put<SkMethod>(url, skMethod, { headers });
  // }

  // delete(id: number): Observable<void> {
  //   const url = `${this.apiUrl}/${id}`;
  //   return this.http.delete<void>(url);
  // }
}
