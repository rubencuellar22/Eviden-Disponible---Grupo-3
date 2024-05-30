import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { MenuService } from '../../services/menu.service';
import { ProfileMenuComponent } from './profile-menu/profile-menu.component';
import { NavbarMenuComponent } from './navbar-menu/navbar-menu.component';
import { AngularSvgIconModule } from 'angular-svg-icon';
import { ComunicacionMenuService } from '../../services/comunicacion-menu.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NavbarMobileComponent } from './navbar-mobile/navbar-mobilecomponent';
import { SidebarMenuComponent } from '../sidebar/sidebar-menu/sidebar-menu.component';
import { Empleado } from 'src/app/core/models/empleado';
import { JobTechnologyProfile } from 'src/app/core/models/JobTechnologyProfile/job-technology-profile';
import { SkTechSkill } from 'src/app/core/models/SkTechSkill/sk-tech-skill';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    AngularSvgIconModule,
    NavbarMenuComponent,
    ProfileMenuComponent,
    NavbarMobileComponent,
  ],
})
export class NavbarComponent implements OnInit {
  filter: string = '';
  filterTags: string[] = [];
  filterComponent: string[] = [];
  empleados: Empleado[] = [];
  empleadosFilter: Empleado[] = [];
  jobTechnologyProfile: JobTechnologyProfile[] = [];
  skTechSkill: SkTechSkill[] = [];
  endpoint: string ="";

  @ViewChild('searchInput') searchInput: ElementRef;
  errorMessage: string = "";
  selectedFilter: string = "";
  tags: [] = [];

  constructor(private menuService: MenuService, private http: HttpClient, private comunicacionMenu: ComunicacionMenuService) {}

  ngOnInit(): void {
    this.comunicacionMenu.focusSearchBar$.subscribe(() => {
      this.focusSearchBar();
    });
  }

  public toggleMobileMenu(): void {
    this.menuService.showMobileMenu = true;
  }

  focusSearchBar() {
    this.searchInput.nativeElement.focus();
  }

  addFilterTag(): void {
    const trimmedFilter = this.filter.trim();
    if (trimmedFilter && !this.filterTags.includes(trimmedFilter)) {
      this.filterTags.push(trimmedFilter);
      this.filter = ''; // Clear the input
      this.endpoint = localStorage.getItem("_endpoint");
      this.selectedFilter = localStorage.getItem("_selectedFilter");

      this.endpoint += trimmedFilter;
      console.log(this.endpoint+"/"+trimmedFilter);
      this.getFunction(this.endpoint);

    }

  }

  getFunction(endpoint: string){
    if(this.empleadosFilter.length === 0) {
      this.http.get<Empleado[]>(endpoint).subscribe(
        (data: Empleado[]) => {
          this.empleados = data;
          this.empleadosFilter = this.empleados;
          console.log(this.empleados);
        },
        (error) => {
          console.error('Error al buscar empleados:', error);
          this.errorMessage = 'Error fetching data.';
        }
      );
    }
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
   
    localStorage.setItem("empleado", JSON.stringify(this.empleados));
    const empleadosJSON = JSON.stringify(localStorage.getItem("empleado"));
    console.log(empleadosJSON);
  }

  removeFilterTag(tag: string): void {
    this.filterTags = this.filterTags.filter(t => t !== tag);
  }

  handleKeydown(event: KeyboardEvent): void {
    if (event.key === 'Enter') {
      this.addFilterTag();
    }
  }
}
