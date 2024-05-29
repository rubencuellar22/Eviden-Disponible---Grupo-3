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
  selectedFilter: string = '';


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

  onEmpleadosFiltrados(event: { empleados: Empleado[], filter: string }): void {
    this.empleados = event.empleados;
    this.selectedFilter = event.filter;
  }
}
