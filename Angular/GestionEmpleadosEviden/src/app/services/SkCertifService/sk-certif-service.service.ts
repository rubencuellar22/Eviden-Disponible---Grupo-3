import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'; 
import { SkCertif } from '../../classes/SkCertif/sk-certif';

@Injectable({
  providedIn: 'root'
})
export class SkCertifService {
  private apiUrl = 'http://localhost:8080/empleado/sk_certif/certif'; 

  constructor(private http: HttpClient) { }

  getAll(): Observable<SkCertif[]> {
    return this.http.get<SkCertif[]>(this.apiUrl);
  }

  getById(id: number): Observable<SkCertif> {
    const url = `${this.apiUrl}/${id}`;
    return this.http.get<SkCertif>(url);
  }

  // create(skCertif: SkCertif): Observable<SkCertif> {
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.post<SkCertif>(this.apiUrl, skCertif, { headers });
  // }

  // update(skCertif: SkCertif): Observable<SkCertif> {
  //   const url = `${this.apiUrl}/${skCertif.id_skcertif}`;
  //   const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
  //   return this.http.put<SkCertif>(url, skCertif, { headers });
  // }

  // delete(id: number): Observable<void> {
  //   const url = `${this.apiUrl}/${id}`;
  //   return this.http.delete<void>(url);
  // }
}
