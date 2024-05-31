import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common'; // Importa CommonModule y DatePipe
import { Nft } from '../../../models/nft';
import { EmpleadoService } from 'src/app/core/services/empleado-service.service';
import { Empleado } from 'src/app/core/models/empleado';
import { EmpleadoStateService } from 'src/app/core/services/EmpleadosStateService/empleado-state.service';

@Component({
    selector: '[nft-auctions-table]',
    templateUrl: './nft-auctions-table.component.html',
    styleUrls: ['./nft-auctions-table.component.css'],
    standalone: true,
    imports: [CommonModule], // Agrega CommonModule a la lista de imports
    providers: [DatePipe] // Agrega DatePipe a la lista de providers
})
export class NftAuctionsTableComponent implements OnInit {
  public activeAuction: Nft[] = [];
  empleados: Empleado[] = []; // Inicializamos empleados como un array vacío

  constructor(private empleadoStateService: EmpleadoStateService) {} // Inyectamos el servicio

  ngOnInit(): void {
    // Llamamos al método del servicio para obtener los empleados
    // this.empleadoService.getEmpleados().subscribe((data: Empleado[]) => {
    //   this.empleados = data; // Asignamos los empleados obtenidos al arreglo empleados
    //   console.log(this.empleados);
    // });
    this.empleadoStateService.updateEmpleados(); // Llamamos al método updateEmpleados del servicio
    this.empleadoStateService.empleado$.subscribe((data: Empleado[]) => {
      this.empleados = data; // Asignamos los empleados obtenidos al arreglo empleados
    });
  }
}
