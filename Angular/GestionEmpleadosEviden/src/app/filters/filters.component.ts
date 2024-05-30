import { Component, EventEmitter, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Empleado } from '../classes/empleado';
import { Grupo } from '../classes/Grupo/grupo';
import { JobTechnologyProfile } from '../classes/JobTechnologyProfile/job-technology-profile';
import { SkTechSkill } from '../classes/SkTechSkill/sk-tech-skill';

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
  jobTechnologyProfile: JobTechnologyProfile[] = [];
  skTechSkill: SkTechSkill[] = [];

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
      
      const filterValue = this.tags[0];
      let endpoint: string;

      switch (this.filterTags[0]) {
        case 'status':
          endpoint = `http://localhost:8080/empleado/status/${filterValue}`;
          this.getFunction(endpoint);
          break;
        case 'bench':
          endpoint = `http://localhost:8080/empleado/bench/${filterValue}`;
          this.getFunction(endpoint);
          break;
        case 'ciudad':
          endpoint = `http://localhost:8080/empleado/ciudad/${filterValue}`;
          this.getFunction(endpoint);
          break;
        case 'jornada':
          endpoint = `http://localhost:8080/empleado/jornada/${filterValue}`;
          this.getFunction(endpoint);
          break;
        case 'grupo':
          endpoint = `http://localhost:8080/empleado/groups/${filterValue}`;
          this.getFunction(endpoint);
          break;
        case 'n4':
          endpoint = `http://localhost:8080/empleado/n4/${filterValue}`;
          this.getFunction(endpoint);
          break;
        case 'categoria':
          endpoint = `http://localhost:8080/empleado/categoria/${filterValue}`;
          this.getFunction(endpoint);
          break;
        case 'scr':
          endpoint = `http://localhost:8080/empleado/scr/${filterValue}`;
          this.getFunction(endpoint);
          break;
        case 'job_technology':
          endpoint = `http://localhost:8080/empleado/job_technology_profile/${filterValue}`;
          if(this.empleadosFilter.length === 0) {
            this.http.get<JobTechnologyProfile[]>(endpoint).subscribe(
              (data: JobTechnologyProfile[]) => {
                this.jobTechnologyProfile = data;
                console.log(this.jobTechnologyProfile);
              },
              (error) => {
                console.error('Error al buscar empleados:', error);
                this.errorMessage = 'Error fetching data.';
              }
            );
          }
          break;
        case 'sk_bus_skill':
          endpoint = `http://localhost:8080/empleado/sk_bussskill/bussskill/${filterValue}`;
          if(this.empleadosFilter.length === 0) {
            this.http.get<Empleado[]>(endpoint).subscribe(
              (data: Empleado[]) => {
                this.empleados = data;
                this.empleadosFilter = this.empleados;
              },
              (error) => {
                console.error('Error al buscar empleados:', error);
                this.errorMessage = 'Error fetching data.';
              }
            );
          }
          break;
        case 'sk_tecnology':
          endpoint = `http://localhost:8080/empleado/sk_technology/technology/${filterValue}`;
          if(this.empleadosFilter.length === 0) {
            this.http.get<Empleado[]>(endpoint).subscribe(
              (data: Empleado[]) => {
                this.empleados = data;
                this.empleadosFilter = this.empleados;
              },
              (error) => {
                console.error('Error al buscar empleados:', error);
                this.errorMessage = 'Error fetching data.';
              }
            );
          }
          break;
        case 'sk_certif':
          endpoint = `http://localhost:8080/empleado/sk_certif/certif/${filterValue}`;
          if(this.empleadosFilter.length === 0) {
            this.http.get<Empleado[]>(endpoint).subscribe(
              (data: Empleado[]) => {
                this.empleados = data;
                this.empleadosFilter = this.empleados;
              },
              (error) => {
                console.error('Error al buscar empleados:', error);
                this.errorMessage = 'Error fetching data.';
              }
            );
          }
          break;
        case 'sk_lenguage':
          endpoint = `http://localhost:8080/empleado/skLenguage/${filterValue}`;
          if(this.empleadosFilter.length === 0) {
            this.http.get<Empleado[]>(endpoint).subscribe(
              (data: Empleado[]) => {
                this.empleados = data;
                this.empleadosFilter = this.empleados;
              },
              (error) => {
                console.error('Error al buscar empleados:', error);
                this.errorMessage = 'Error fetching data.';
              }
            );
          }
          break;
        case 'sk_method':
          endpoint = `http://localhost:8080/empleado/sk_methods/${filterValue}`;
          if(this.empleadosFilter.length === 0) {
            this.http.get<Empleado[]>(endpoint).subscribe(
              (data: Empleado[]) => {
                this.empleados = data;
                this.empleadosFilter = this.empleados;
              },
              (error) => {
                console.error('Error al buscar empleados:', error);
                this.errorMessage = 'Error fetching data.';
              }
            );
          }
          break;
        case 'sk_tecskill':
          endpoint = `http://localhost:8080/empleado/skTechskill/${filterValue}`;
          if(this.empleadosFilter.length === 0) {
            this.http.get<SkTechSkill[]>(endpoint).subscribe(
              (data: SkTechSkill[]) => {
                this.skTechSkill = data;
                console.log(this.skTechSkill);
              },
              (error) => {
                console.error('Error al buscar empleados:', error);
                this.errorMessage = 'Error fetching data.';
              }
            );
          }
          break;  
        
        default:
          console.error('Filtro no reconocido:', this.selectedFilter);
          this.errorMessage = 'Unrecognized filter selected.';
          return;
      }
      
    }
  }

  getFunction(endpoint: string){
    if(this.empleadosFilter.length === 0) {
      this.http.get<Empleado[]>(endpoint).subscribe(
        (data: Empleado[]) => {
          this.empleados = data;
          this.empleadosFilter = this.empleados;
        },
        (error) => {
          console.error('Error al buscar empleados:', error);
          this.errorMessage = 'Error fetching data.';
        }
      );
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
    

    // console.log(this.tags);
    // console.log(this.filterTags);
    // console.log(this.empleadosFilter.length);

    this.empleados = [];
    

    for(let i = 0; i < this.filterTags.length; i++){ 
      if (this.empleadosFilter.length != 0) {
        console.log(this.empleados);  
        for(let empleado of this.empleadosFilter){
          switch (this.filterTags[i]) {
            case 'status':
              if(empleado.status = this.tags[i]){
                this.empleados.push(empleado);
              }
              break;
            case 'bench':
              // if(empleado.bench = this.tags[i]){
              //   this.empleados.push(empleado);
              // }
              break;
            case 'ciudad':
              if(empleado.ciudad = this.tags[i]){
                this.empleados.push(empleado);
              }
              break;
            case 'jornada':
              if(empleado.jornada = parseInt(this.tags[i])){
                this.empleados.push(empleado);
              }
              break;
            case 'grupo':
              if(empleado.grupo.grupos.includes(this.tags[i])){
                this.empleados.push(empleado);
              }
              break;
            case 'n4':
              if(empleado.n4 = this.tags[i]){
                this.empleados.push(empleado);
              }
              break;
            case 'categoria':
              if(empleado.categoria = this.tags[i]){
                this.empleados.push(empleado);
              }
              break;
            case 'scr':
              if(empleado.scr = parseInt(this.tags[i])){
                this.empleados.push(empleado);
              }
              break;
            case 'job_technology':
              if(empleado.jobTechnology = this.tags[i]){
                this.empleados.push(empleado);
              }
              break;
            case 'sk_bus_skill':
              for(let sk_bus_skill of empleado.skBusSkills){
                if(sk_bus_skill.skBusSkill.includes(this.tags[i])){
                  this.empleados.push(empleado);
                }
              }
              break;
            case 'sk_tecnology':
              for(let sk_technology of empleado.skTechnologies){
                if(sk_technology.sktechnology.includes(this.tags[i])){
                  this.empleados.push(empleado);
                }
              }
              break;
            case 'sk_certif':
              for(let sk_certif of empleado.skCertifs){
                if(sk_certif.skCertif.includes(this.tags[i])){
                  this.empleados.push(empleado);
                }
              }
              break;
            case 'sk_lenguage':
              for(let skLenguage of empleado.skLenguages){
                if(skLenguage.sklenguage.includes(this.tags[i])){
                  this.empleados.push(empleado);
                }
              }
              break;
            case 'sk_method':
              for(let sk_method of empleado.skMethods){
                if(sk_method.skmethod.includes(this.tags[i])){
                  this.empleados.push(empleado);
                }
              }
              break;
            case 'sk_tecskill':
              for(let skTechSkills of empleado.skTechSkills){
                if(skTechSkills.skTechSkill.includes(this.tags[i])){
                  this.empleados.push(empleado);
                }
              }
              break;  
            
            default:
              console.error('Filtro no reconocido:', this.selectedFilter);
              this.errorMessage = 'Unrecognized filter selected.';
              return;
          }
        }
        
      }
    }
    this.empleadosFiltrados.emit({
      empleados: this.empleados,
      filter: this.selectedFilter,
    });
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
