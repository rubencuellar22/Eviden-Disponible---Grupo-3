import { Component, EventEmitter, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, startWith, debounceTime, switchMap } from 'rxjs/operators';
import { FormControl } from '@angular/forms';
import { Empleado } from '../classes/empleado';
import { JobTechnologyProfile } from '../classes/JobTechnologyProfile/job-technology-profile';
import { SkTechSkill } from '../classes/SkTechSkill/sk-tech-skill';
import { Role } from '../classes/role/role';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css'],
})
export class FiltersComponent {
  newTag: string = '';
  tags: string[] = [];
  filterOptions: string[] = [];
  filteredOptions: Observable<string[]>;
  tagControl = new FormControl();
  filterTags: string[] = [];
  empleados: Empleado[] = [];
  empleadosFilter: Empleado[] = [];
  empleadosDuplicado: Empleado[] = [];
  jobTechnologyProfile: JobTechnologyProfile[] = [];
  skTechSkill: SkTechSkill[] = [];
  role: Role[] = [];

  selectedFilter: string = '';
  errorMessage: string = '';

  @Output() empleadosFiltrados = new EventEmitter<{
    empleados: Empleado[];
    filter: string;
  }>();

  constructor(private http: HttpClient) {
    this.filteredOptions = this.tagControl.valueChanges.pipe(
      debounceTime(300),
      switchMap(value => this.fetchFilteredOptions(value || ''))
    );
  }

  fetchFilteredOptions(query: string): Observable<string[]> {
    console.log('fetchFilteredOptions called with query:', query); // Mensaje de depuración

    if (!this.selectedFilter) {
      return new Observable<string[]>(subscriber => {
        subscriber.next([]);
      });
    }

    let endpoint: string;

    switch (this.selectedFilter) {
      case 'job_technology_profile':
        endpoint = `http://localhost:8080/empleado/jobTechnologyProfile/autocomplete`;
        break;
      default:
        endpoint = `http://localhost:8080/empleado/autocomplete`;
        break;
    }

    return this.http.get<string[]>(endpoint, { params: { query, filterType: this.selectedFilter } });
  }

  addTag(): void {
    if (this.newTag && !this.tags.includes(this.newTag)) {
      this.tags.push(this.newTag);
      console.log(`Tag added: ${this.newTag}`); // Mensaje de depuración
      this.newTag = '';
      this.filterTags.push(this.selectedFilter); // Agrega el filtro seleccionado a la lista
    }
  }

  getEmpleadoProperties(empleado: Empleado): { key: string, value: any }[] {
    const properties: { key: string, value: any }[] = [];
    for (const key in empleado) {
      if (empleado.hasOwnProperty(key)) {
        properties.push({ key, value: empleado[key] });
      }
    }
    return properties;
  }
  

  onInputChange(): void {
    const query = this.tagControl.value;
    if (query && this.selectedFilter) {
      this.fetchFilteredOptions(query).subscribe(
        options => {
          this.filterOptions = options;
          console.log('Filtered options:', options); // Mensaje de depuración
        },
        error => console.error('Error fetching options', error)
      );
    }
  }

  selectOption(option: string): void {
    this.tagControl.setValue(option);
    this.filterOptions = []; // Limpiar las opciones después de seleccionar una
  }

  removeTag(tag: string): void {
    this.tags = this.tags.filter((t) => t !== tag);
    this.filterTags = this.filterTags.filter((t, index) => this.tags[index] !== tag); // Asegúrate de mantener los tags y filterTags sincronizados
  }

  applyFilter(): void {
    this.errorMessage = '';
    if (!this.filterTags.length) {
      this.errorMessage = 'Please select at least one filter.';
      return;
    }
    if (this.tags.length === 0) {
      this.errorMessage = 'Please add at least one tag.';
      return;
    }

    const filterOrder = [
      'status', 'bench', 'ciudad', 'jornada', 'grupo', 'n4', 'categoria', 'scr', 
      'job_technology_profile', 'sk_bus_skill', 'sk_technology', 'sk_certif', 
      'sk_lenguage', 'sk_method', 'sk_tecskill', 'role'
    ];

    const sortedFilterTags = this.filterTags.slice().sort((a, b) => filterOrder.indexOf(a) - filterOrder.indexOf(b));

    let endpoint = `http://localhost:8080/empleado/empleados?`;

    for (let i = 0; i < sortedFilterTags.length; i++) {
      const filterKey = sortedFilterTags[i];
      const filterValue = this.tags[this.filterTags.indexOf(filterKey)];

      switch (filterKey) {
        case 'status':
          endpoint += `status=${filterValue}&`;
          break;
        case 'bench':
          endpoint += `bench=${filterValue}&`;
          break;
        case 'ciudad':
          endpoint += `ciudad=${filterValue}&`;
          break;
        case 'jornada':
          endpoint += `jornada=${filterValue}&`;
          break;
        case 'grupo':
          endpoint += `grupo=${filterValue}&`;
          break;
        case 'n4':
          endpoint += `n4=${filterValue}&`;
          break;
        case 'categoria':
          endpoint += `categoria=${filterValue}&`;
          break;
        case 'scr':
          endpoint += `scr=${filterValue}&`;
          break;
        case 'job_technology_profile':
          endpoint += `jobTechnologyProfile=${filterValue}&`;
          break;
        case 'sk_bus_skill':
          endpoint += `skBussskill=${filterValue}&`;
          break;
        case 'sk_technology':
          endpoint += `skTechnology=${filterValue}&`;
          break;
        case 'sk_certif':
          endpoint += `skCertif=${filterValue}&`;
          break;
        case 'sk_lenguage':
          endpoint += `skLenguage=${filterValue}&`;
          break;
        case 'sk_method':
          endpoint += `skMethod=${filterValue}&`;
          break;
        case 'sk_tecskill':
          endpoint += `skTechskill=${filterValue}&`;
          break;
        case 'role':
          endpoint += `role=${filterValue}&`;
          break;
        default:
          console.error('Unrecognized filter:', filterKey);
          this.errorMessage = 'Unrecognized filter selected.';
          return;
      }
    }

    if (endpoint.endsWith('&')) {
      endpoint = endpoint.slice(0, -1);
    }

    console.log('Endpoint construido:', endpoint);

    this.http.get<Empleado[]>(endpoint).subscribe(
      (data: Empleado[]) => {
        this.empleados = data;
        console.log('Datos recibidos:', this.empleados); // Depuración
        this.empleadosFiltrados.emit({
          empleados: this.empleados,
          filter: this.selectedFilter,
        });
      },
      (error) => {
        console.error('Error fetching data:', error);
        this.errorMessage = 'Error fetching data.';
      }
    );
  }
}
