import { Component, EventEmitter, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empleado } from '../classes/empleado';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent {
  newTag: string = '';
  tags: string[] = [];
  empleados: Empleado[] = [];

  @Output() empleadosFiltrados = new EventEmitter<Empleado[]>();

  constructor(private http: HttpClient) {}

  addTag(): void {
    if (this.newTag && !this.tags.includes(this.newTag)) {
      this.tags.push(this.newTag);
      this.newTag = '';
    }
  }

  removeTag(tag: string): void {
    this.tags = this.tags.filter(t => t !== tag);
  }

  applyFilter(): void {
    const ciudadTag = this.tags.find(tag => tag.toLowerCase() === 'madrid');
    if (ciudadTag) {
      this.http.get<Empleado[]>(`http://localhost:8080/empleado/ciudad/${ciudadTag}`).subscribe(
        (data: Empleado[]) => {
          this.empleados = data;
          this.empleadosFiltrados.emit(this.empleados); // Emitir los empleados filtrados al componente padre
        },
        error => {
          console.error('Error al buscar empleados:', error);
        }
      );
    }
  }
}
