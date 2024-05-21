
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Grupo } from '../../classes/Grupo/grupo';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {
  private apiUrl = 'http://your-api-url/grupos'; // Reemplaza con tu URL real de la API

  constructor(private http: HttpClient) {}

  getGrupos(): Observable<Grupo[]> {
    return this.http.get<Grupo[]>(this.apiUrl);
  }

  getGrupoById(id: number): Observable<Grupo> {
    return this.http.get<Grupo>(`${this.apiUrl}/${id}`);
  }

  // createGrupo(grupo: Grupo): Observable<Grupo> {
  //   return this.http.post<Grupo>(this.apiUrl, grupo);
  // }

  // updateGrupo(id: number, grupo: Grupo): Observable<Grupo> {
  //   return this.http.put<Grupo>(`${this.apiUrl}/${id}`, grupo);
  // }

  // deleteGrupo(id: number): Observable<void> {
  //   return this.http.delete<void>(`${this.apiUrl}/${id}`);
  // }
}
