import { Component, OnInit } from '@angular/core';
import { EmpleadoService } from './services/empleado-service.service'; // Asegúrate de importar el servicio correcto
import { Empleado } from './classes/empleado';

@Component({
  selector: 'app-details',
  templateUrl: './app.component.html'
})
export class DetailsComponent implements OnInit {
  empleados: Empleado[] = []; // Inicializamos empleados como un array vacío
  
  constructor(private empleadoService: EmpleadoService) {} // Inyectamos el servicio
  
  ngOnInit(): void {
    // Llamamos al método del servicio para obtener los empleados
    this.empleadoService.getEmpleados().subscribe((data: any[]) => {
      this.empleados = data; // Asignamos los empleados obtenidos al arreglo empleados
    });
  }
}