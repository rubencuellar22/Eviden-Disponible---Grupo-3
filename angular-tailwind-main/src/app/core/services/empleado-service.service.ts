// empleado.service.ts
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Empleado } from '../models/empleado';
import { HttpClient } from '@angular/common/http';

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

  getEmpleadosByCiudad(ciudad: string): Observable<Empleado[]> {
    return this.http.get<Empleado[]>(`${this.apiUrl}ciudad/${ciudad}`);
  }
}
