import { Component, Input } from '@angular/core';
import { Empleado } from '../classes/empleado';

@Component({
  selector: 'app-filtered-table',
  templateUrl: './filtered-table.component.html',
  styleUrls: ['./filtered-table.component.css']
})
export class FilteredTableComponent {
  @Input() empleados: Empleado[] = [];
  @Input() selectedFilter: string = '';
}
