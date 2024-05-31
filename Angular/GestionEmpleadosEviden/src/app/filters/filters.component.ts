import { Component, EventEmitter, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, startWith, debounceTime, switchMap } from 'rxjs/operators';
import { FormControl } from '@angular/forms';
import { Empleado } from '../classes/empleado';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css'],
})
export class FiltersComponent {
  newTag: string = '';
  tags: string[] = [];
  selectedFilter: string = '';
  errorMessage: string = '';
  filterOptions: string[] = [];
  filteredOptions: Observable<string[]>;
  tagControl = new FormControl();

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
    const newTag = this.tagControl.value;
    if (newTag && !this.tags.includes(newTag)) {
      this.tags.push(newTag);
      this.tagControl.setValue('');
    }
  }

  removeTag(tag: string): void {
    this.tags = this.tags.filter((t) => t !== tag);
  }

  selectOption(option: string): void {
    this.tagControl.setValue(option);
    this.filterOptions = []; // Limpiar las opciones después de seleccionar una
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

    switch (this.selectedFilter) {
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

    this.http.get<string[]>(endpoint).subscribe(
      (data: string[]) => {
        this.filterOptions = data;
        console.log('Data fetched:', data); // Mensaje de depuración
      },
      (error) => {
        console.error('Error fetching filter options:', error);
      }
    );
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
}
