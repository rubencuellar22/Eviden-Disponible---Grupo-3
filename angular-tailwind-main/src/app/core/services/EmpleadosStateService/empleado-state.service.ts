import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Empleado } from '../../models/empleado';
import { EmpleadoService } from '../empleado-service.service';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoStateService {
  private empleadoSubject = new BehaviorSubject<Empleado[]>([]);
  empleado$ = this.empleadoSubject.asObservable();

  private showImportExcel = new BehaviorSubject<boolean>(true);
  showImportExcel$ = this.showImportExcel.asObservable();

  constructor(private empleadoService: EmpleadoService) { }

  updateEmpleados() {
    this.empleadoService.getEmpleados().subscribe(empleados => {
      this.empleadoSubject.next(empleados);
      if (empleados.length > 0) {
        this.showImportExcel.next(false);
      }
    });
  }

  toggleShowImportExcel() {
    this.showImportExcel.next(!this.showImportExcel.value);
  }
}
