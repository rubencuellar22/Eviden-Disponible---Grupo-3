import { Component } from '@angular/core';
import { Empleado } from '../classes/empleado';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  styleUrls: ['./first-page.component.css']
})
export class FirstPageComponent {
  empleados: Empleado[] = [];

  constructor(private http: HttpClient) {}

  loadEmpleados() {
    this.http.get<Empleado[]>('http://localhost:8080/empleado').subscribe(
      (data: Empleado[]) => {
        this.empleados = data;
      },
      error => {
        console.error('Error al cargar empleados:', error);
      }
    );
  }

  onEmpleadosFiltrados(empleadosFiltrados: Empleado[]) {
    this.empleados = empleadosFiltrados; // Actualizar los empleados con los filtrados
  }
}
