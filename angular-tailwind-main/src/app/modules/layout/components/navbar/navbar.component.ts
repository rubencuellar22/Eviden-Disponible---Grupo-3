import { Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { MenuService } from '../../services/menu.service';
import { ProfileMenuComponent } from './profile-menu/profile-menu.component';
import { NavbarMenuComponent } from './navbar-menu/navbar-menu.component';
import { AngularSvgIconModule } from 'angular-svg-icon';
import { ComunicacionMenuService } from '../../services/comunicacion-menu.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NavbarMobileComponent } from './navbar-mobile/navbar-mobilecomponent';
import { Empleado } from 'src/app/core/models/empleado';
import { JobTechnologyProfile } from 'src/app/core/models/JobTechnologyProfile/job-technology-profile';
import { SkTechSkill } from 'src/app/core/models/SkTechSkill/sk-tech-skill';
import { HttpClient } from '@angular/common/http';
import { NftAuctionsTableComponent } from '../../../dashboard/components/nft/nft-auctions-table/nft-auctions-table.component';
import { DataService } from 'src/app/app.service.import';

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
    NftAuctionsTableComponent,
  ],
})
export class NavbarComponent implements OnInit {
  filter: string = '';
  filterTags: string[] = [];
  filterComponent: string[] = [];
  filterComponentSubItem: string[] = [];
  empleados: Empleado[] = [];
  jobTechnologyProfile: JobTechnologyProfile[] = [];
  skTechSkill: SkTechSkill[] = [];

  @ViewChild('searchInput') searchInput: ElementRef;
  errorMessage: string = '';
  selectedItem: string = '';
  selectedSubItem: string = '';
  tags: string[] = [];

  constructor(
    private menuService: MenuService,
    private http: HttpClient,
    private comunicacionMenu: ComunicacionMenuService,
    private dataService: DataService,
  ) {}

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
      this.selectedItem = localStorage.getItem('_selectedItem');
      this.selectedSubItem = localStorage.getItem('_selectedSubItem');
      this.filterComponent.push(this.selectedItem);
      if(this.selectedSubItem.length == 0){
        this.filterComponentSubItem.push('vacio');
      }
      else{
        this.filterComponentSubItem.push(this.selectedSubItem);
      }
      
      this.getFunction();
    }
  }

  getFunction(): void {
    this.empleados = [];
    for (let i = 0; i < this.filterTags.length; i++) {
      let endpoint = `http://localhost:8080/empleado/empleados?`;
      const filterValue = this.filterTags[i];
      console.log(filterValue);
      console.log(this.filterComponent[i]);
      console.log(this.filterComponentSubItem[i]);
      switch (this.filterComponent[i]) {
        case 'Status':
          endpoint += `status=${filterValue}&`;
          break;
        case 'Bench':
          endpoint += `bench=${filterValue}&`;
          break;
        case 'Ciudad':
          endpoint += `ciudad=${filterValue}&`;
          break;
        case 'Jornada':
          endpoint += `jornada=${filterValue}&`;
          break;
        case 'Grupo':
          endpoint += `grupo=${filterValue}&`;
          break;
        case 'N_4':
          endpoint += `n4=${filterValue}&`;
          break;
        case 'Categoría':
          endpoint += `categoria=${filterValue}&`;
          break;
        case 'SCR (+iud)':
          endpoint += `scr=${filterValue}&`;
          break;
        case 'SkLanguage':
          endpoint = `http://localhost:8080/empleado/skLenguage/${filterValue}/${this.selectedSubItem}&`;
          console.log("ENDPOINT: "+endpoint);
          break;
        case 'SkTechnologies':
          endpoint = `http://localhost:8080/empleado/skTechnology/${filterValue}/${this.selectedSubItem}&`;
          break;
        case 'SkTechSkills':
          endpoint = `http://localhost:8080/empleado/skTechskill/${filterValue}/${this.selectedSubItem}&`;
          break;
        case 'SkCertif':
          endpoint = `http://localhost:8080/empleado/skCertif/${filterValue}/${this.selectedSubItem}&`;
          break;
        case 'SkMethods':
          endpoint = `http://localhost:8080/empleado/skMethod/${filterValue}/${this.selectedSubItem}&`;
          break;
        case 'SkBusSkills':
          endpoint = `http://localhost:8080/empleado/skBussskill/${filterValue}/${this.selectedSubItem}&`;
          break;
        default:
          console.error('Unrecognized filter:', this.filterTags[i]);
          this.errorMessage = 'Unrecognized filter selected.';
        return;
      }
      // Elimina el último '&' si existe
      endpoint = endpoint.slice(0, -1);

      // Realiza la llamada HTTP con la URL construida
      this.consultaGet(endpoint);

    }

    if(this.filterComponent.length == 0) {
      let endpoint = 'http://localhost:8080/empleado/';

      this.consultaGet(endpoint);
    }
  }

  consultaGet(endpoint: string): void{
    this.http.get<Empleado[]>(endpoint).subscribe(
      (data: Empleado[]) => {
        // Actualiza la lista de empleados filtrados
        this.empleados = data;
        console.log(endpoint);
        console.log(this.empleados);
        // Emite el evento con los empleados filtrados
        this.dataService.changeData(this.empleados);

      },
      (error) => {
        console.error(`Error fetching data:`, error);
        this.errorMessage = 'Error fetching data.';
      }
    );
  }

  removeFilterTag(tag: string): void {
    const index = this.filterTags.indexOf(tag);
    if (index !== -1) {
      this.filterTags = this.filterTags.filter((t) => t !== tag);
      this.filterComponent.splice(index, 1);
      this.filterComponentSubItem.splice(index, 1);
    }
    //Llamar al método que haga los filtros múltiples
    this.getFunction();
  }

  handleKeydown(event: KeyboardEvent): void {
    if (event.key === 'Enter') {
      this.addFilterTag();
    }
  }
}
