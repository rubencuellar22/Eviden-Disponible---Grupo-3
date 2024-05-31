import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Empleado } from './core/models/empleado';

@Injectable({
  providedIn: 'root'
})
export class DataService {
    private dataSource = new BehaviorSubject<Empleado[]>(null);
    private checkSource = new BehaviorSubject<boolean>(true); // Nuevo BehaviorSubject para check
  
    currentData = this.dataSource.asObservable();
    currentCheck = this.checkSource.asObservable(); // Observable para check
  
    constructor() { }
  
    changeData(data: Empleado[]) {
      this.dataSource.next(data);
      this.changeCheck(false); // Actualiza el valor de check cuando cambias los datos
    }
  
    changeCheck(value: boolean) {
      this.checkSource.next(value);
    }

    changeToExport(){
        this.checkSource.next(true)
    }
}
