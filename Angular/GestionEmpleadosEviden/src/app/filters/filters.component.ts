import { Component, EventEmitter, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empleado } from '../classes/empleado';
import { Grupo } from '../classes/Grupo/grupo';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css'],
})
export class FiltersComponent {
  newTag: string = '';
  tags: string[] = [];
  filterTags: string[] = [];
  empleados: Empleado[] = [];
  empleadosFilter: Empleado[] = [];
  arrayGrupo: Grupo[] = [];
  selectedFilter: string = '';
  errorMessage: string = '';
  filtroCheck: string;

  @Output() empleadosFiltrados = new EventEmitter<{
    empleados: Empleado[];
    filter: string;
  }>();

  constructor(private http: HttpClient) {}

  addTag(): void {
    if (this.newTag && !this.tags.includes(this.newTag)) {
      this.tags.push(this.newTag);
      this.newTag = '';
      this.filterTags.push(this.selectedFilter);
    }
  }

  removeTag(tag: string): void {
    this.tags = this.tags.filter((t) => t !== tag);
  }

  applyFilter(): void {
    this.errorMessage = '';
    if (!this.selectedFilter) {
      this.errorMessage = 'Please select a filter.';
      return;
    }
    if (this.tags.length === 0) {
      this.errorMessage = 'Please add at least one tag.';
      return;
    }

    const filterValue = this.tags[0];
    let endpoint: string;

    switch (this.filterTags[0]) {
      case 'status':
        endpoint = `http://localhost:8080/empleado/status/${filterValue}`;
        break;
      case 'bench':
        endpoint = `http://localhost:8080/empleado/bench/${filterValue}`;
        break;
      case 'ciudad':
        endpoint = `http://localhost:8080/empleado/ciudad/${filterValue}`;
        break;
      case 'jornada':
        endpoint = `http://localhost:8080/empleado/jornada/${filterValue}`;
        break;
      case 'grupo':
        endpoint = `http://localhost:8080/empleado/groups/${filterValue}`;
        break;
      case 'n4':
        endpoint = `http://localhost:8080/empleado/n4/${filterValue}`;
        break;
      case 'categoria':
        endpoint = `http://localhost:8080/empleado/categoria/${filterValue}`;
        break;
      case 'scr':
        endpoint = `http://localhost:8080/empleado/scr/${filterValue}`;
        break;
      case 'job_technology':
        endpoint = `http://localhost:8080/empleado/job_technology_profile/${filterValue}`;
        break;
      case 'sk_bus_skill':
        endpoint = `http://localhost:8080/empleado/sk_bussskill/bussskill/${filterValue}`;
        break;
      case 'sk_tecnology':
        endpoint = `http://localhost:8080/empleado/sk_technology/technology/${filterValue}`;
        break;
      case 'sk_certif':
        endpoint = `http://localhost:8080/empleado/sk_certif/certif/${filterValue}`;
        break;
      case 'sk_lenguage':
        endpoint = `http://localhost:8080/empleado/skLenguage/${filterValue}`;
        break;
      case 'sk_method':
        endpoint = `http://localhost:8080/empleado/sk_methods/${filterValue}`;
        break;
      case 'sk_tecskill':
        endpoint = `http://localhost:8080/empleado/sk_techskills/${filterValue}`;
        break;  
       

      default:
        console.error('Filtro no reconocido:', this.selectedFilter);
        this.errorMessage = 'Unrecognized filter selected.';
        return;
    }

    console.log(this.tags);
    console.log(this.filterTags);

    for(let i = 0; i < this.filterTags.length; i++){     
      if (this.empleados.length === 0) {
        console.log(endpoint);
        this.http.get<Empleado[]>(endpoint).subscribe(
          (data: Empleado[]) => {
            console.log(this.empleadosFilter);
            this.empleados = data;
            this.empleadosFilter = this.empleados;
            this.empleadosFiltrados.emit({
              empleados: this.empleados,
              filter: this.selectedFilter,
            });
          },
          (error) => {
            console.error('Error al buscar empleados:', error);
            this.errorMessage = 'Error fetching data.';
          }
        );
      }
      else {
        console.log('adios');
        
        
      }
    }
  }

  // recogerGrupo(): Grupo[] {
  //   let data: Grupo = new Grupo;
  //   for(let empleado of this.empleados) {
  //       data = empleado.grupo; 
  //       this.arrayGrupo.push(data);
  //   }
  //   console.log(this.arrayGrupo);

  //   return this.arrayGrupo;
  // }
}
