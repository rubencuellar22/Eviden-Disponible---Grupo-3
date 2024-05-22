import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empleado } from '../classes/empleado';


@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {
  newTag: string = '';
  tags: string[] = [];
  empleados: Empleado[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {}

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
    console.log("hola");
    if (ciudadTag) {
      console.log("Aqui llega");
      this.http.get<Empleado[]>(`http://localhost:8080/empleado/ciudad/${ciudadTag}`).subscribe(
        (data: Empleado[]) => {
          this.empleados = data;
        },
        error => {
          console.error('Error al buscar empleados:', error);
        }
      );
    }
  }
}
