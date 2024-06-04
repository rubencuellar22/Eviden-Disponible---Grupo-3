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
import { map } from 'rxjs';

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
      this.filterComponent.push(this.selectedItem); // Añadir selectedFilter a filterComponent

      this.getFunction();
    }
  }

  getFunction(): void {
    for (let i = 0; i < this.filterTags.length; i++) {
      let endpoint = `http://localhost:8080/empleado/empleados?`;
      const filterValue = this.filterTags[i];
      console.log(filterValue);
      console.log(this.filterComponent[i]);
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
        case 'Categoria':
          endpoint += `categoria=${filterValue}&`;
          break;
        case 'SCR (+iud)':
          endpoint += `scr=${filterValue}&`;
          break;
        case 'SkLanguage':
          endpoint = `http://localhost:8080/empleado/skLenguage/${filterValue}/${this.selectedSubItem}&`;
          console.log('ENDPOINT: ' + endpoint);
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
        },
      );
    }
  }

  removeFilterTag(tag: string): void {
    const index = this.filterTags.indexOf(tag);
    if (index !== -1) {
      this.filterTags = this.filterTags.filter((t) => t !== tag);
      this.filterComponent.splice(index, 1);
    }
    //Llamar al método que haga los filtros múltiples
  }

  handleKeydown(event: KeyboardEvent): void {
    if (event.key === 'Enter') {
      this.addFilterTag();
    }
  }

  autocomplete(query: string) {
    this.selectedItem = localStorage.getItem('_selectedItem').toLowerCase(); // Convertir a minúsculas
    let endpoint: string;
    let params: any = { query }; // Inicializar los parámetros con el query

    // Conversión específica para algunos valores de this.selectedItem
    switch (this.selectedItem) {
      case 'n_4':
        params.filterType = 'n4'; // Agregar el tipo de filtro
        break;
      case 'categoría':
        params.filterType = 'categoria'; // Agregar el tipo de filtro
        break;
      case 'scr (+iud)':
        params.filterType = 'scr'; // Agregar el tipo de filtro
        break;
      case 'skcertif':
        endpoint = 'http://localhost:8080/empleado/skCertif/autocomplete';
        break;
      default:
        endpoint = 'http://localhost:8080/empleado/autocomplete';
        params.filterType = this.selectedItem; // Agregar el tipo de filtro
        break;
    }

    if (!endpoint) {
      // Si no hay un endpoint específico, usar el endpoint genérico
      endpoint = 'http://localhost:8080/empleado/autocomplete';
    }

    console.log('Endpoint completo:', endpoint); // Agregamos el console.log aquí

    console.log(params);
    const request = this.http.get<string[]>(endpoint, { params }).pipe(
      map((data: string[]) => {
        // Filtrar las sugerencias basadas en la entrada del usuario
        return data.filter(
          (suggestion) => typeof suggestion === 'string' && suggestion.toLowerCase().startsWith(query.toLowerCase()),
        );
      }),
    );

    console.log('Request:', request); // Agregamos el console.log para el request

    return request;
  }

  suggestions: string[] = [];

  onFilterChange() {
    // Llama al método de autocompletar cuando cambie el valor del filtro
    this.autocomplete(this.filter).subscribe(
      (data: string[]) => {
        this.suggestions = data;
      },
      (error) => {
        console.error('Error fetching autocomplete suggestions:', error);
      },
    );
  }

  selectSuggestion(suggestion: string) {
    this.filter = suggestion;
    this.suggestions = []; // Limpiar la lista de sugerencias
  }
}
