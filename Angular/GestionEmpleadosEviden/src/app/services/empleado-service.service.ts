import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Empleado } from '../classes/empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  private apiUrl = 'http://localhost:8080/empleado/';

  constructor(private http: HttpClient) {}

  getEmpleados(): Observable<Empleado[]> {
    return this.http.get<Empleado[]>(this.apiUrl);
  }

  getEmpleadoById(id: number): Observable<Empleado> {
    return this.http.get<Empleado>(`${this.apiUrl}/${id}`);
  }

  // createEmpleado(empleado: Empleado): Observable<Empleado> {
  //   return this.http.post<Empleado>(this.apiUrl, empleado);
  // }

  // updateEmpleado(id: number, empleado: Empleado): Observable<Empleado> {
  //   return this.http.put<Empleado>(`${this.apiUrl}/${id}`, empleado);
  // }

  // deleteEmpleado(id: number): Observable<void> {
  //   return this.http.delete<void>(`${this.apiUrl}/${id}`);
  // }
}