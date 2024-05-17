import { Component, OnInit } from '@angular/core';
import { EmpleadoService } from '../services/empleado-service.service'; // Asegúrate de importar el servicio correcto

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  empleados: any[] = []; // Inicializamos empleados como un array vacío
  
  constructor(private empleadoService: EmpleadoService) {} // Inyectamos el servicio
  
  ngOnInit(): void {
    // Llamamos al método del servicio para obtener los empleados
    this.empleadoService.getEmpleados().subscribe((data: any[]) => {
      this.empleados = data; // Asignamos los empleados obtenidos al arreglo empleados
    });
  }
}
