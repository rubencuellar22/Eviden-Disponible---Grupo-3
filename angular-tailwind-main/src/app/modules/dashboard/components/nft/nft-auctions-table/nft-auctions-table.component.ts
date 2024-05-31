import { Component, OnInit, Input } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common'; // Importa CommonModule y DatePipe
import { Nft } from '../../../models/nft';
import { Empleado } from 'src/app/core/models/empleado';
import { EmpleadoStateService } from 'src/app/core/services/EmpleadosStateService/empleado-state.service';
import { DataService } from 'src/app/app.service.import';

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
  check: boolean = true;
  empleadosMostrar: Empleado[] = [];
  empleadosFlitrados: Empleado[] = [];

  
  constructor(private empleadoStateService: EmpleadoStateService, private dataService: DataService) {} // Inyectamos el servicio

  ngOnInit(): void {

      this.empleadoStateService.updateEmpleados(); // Llamamos al método updateEmpleados del servicio
      
      this.empleadoStateService.empleado$.subscribe((data: Empleado[]) => {
        this.empleadosMostrar = data; // Asignamos los empleados obtenidos al arreglo empleados
      });

      this.dataService.currentData.subscribe((data: Empleado[]) => {
        this.empleadosFlitrados = data;
      });
  
      this.dataService.currentCheck.subscribe((check: boolean) => {
        this.check = check;
      });
    }
}
