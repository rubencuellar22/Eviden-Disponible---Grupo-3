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
import { NftAuctionsTableComponent } from "../../../dashboard/components/nft/nft-auctions-table/nft-auctions-table.component";
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
        NftAuctionsTableComponent
    ]
})
export class NavbarComponent implements OnInit {
  filter: string = '';
  filterTags: string[] = [];
  filterComponent: string[] = [];
  empleados: Empleado[] = [];
  jobTechnologyProfile: JobTechnologyProfile[] = [];
  skTechSkill: SkTechSkill[] = [];
  endpoint: string = '';

  @ViewChild('searchInput') searchInput: ElementRef;
  errorMessage: string = '';
  selectedItem: string = '';
  tags: [] = [];


  constructor(private menuService: MenuService, private http: HttpClient, private comunicacionMenu: ComunicacionMenuService, private dataService: DataService) {}


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
      this.endpoint = localStorage.getItem('_endpoint');
      this.selectedItem = localStorage.getItem('_selectedItem');
      this.filterComponent.push(this.selectedItem); // Añadir selectedFilter a filterComponent
  
      this.endpoint += trimmedFilter;
      console.log(this.endpoint + '/' + trimmedFilter);
      this.getFunction(this.endpoint);
    }
  }
  

  getFunction(endpoint: string): void {
      this.http.get<Empleado[]>(endpoint).subscribe(
        (data: Empleado[]) => {
          this.empleados = data;
          console.log(this.empleados);
          this.dataService.changeData(this.empleados);

        },
        (error) => {
          console.error('Error al buscar empleados:', error);
          this.errorMessage = 'Error fetching data.';
        },
      );
  }


  removeFilterTag(tag: string): void {
    const index = this.filterTags.indexOf(tag);
    if (index !== -1) {
      this.filterTags = this.filterTags.filter((t) => t !== tag);
      this.filterComponent.splice(index, 1);
      console.log(this.filterTags);
      console.log(this.filterComponent);
    }
    //Llamar al método que haga los filtros múltiples
  }

  handleKeydown(event: KeyboardEvent): void {
    if (event.key === 'Enter') {
      this.addFilterTag();
    }
  }
}
