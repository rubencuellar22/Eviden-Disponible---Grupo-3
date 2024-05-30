import { ChangeDetectionStrategy, Component, EventEmitter, OnInit, Output } from '@angular/core';
import { SubMenuItem } from 'src/app/core/models/menu.model';
import { SidebarSubmenuComponent } from '../sidebar-submenu/sidebar-submenu.component';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { AngularSvgIconModule } from 'angular-svg-icon';
import { NgFor, NgClass, NgTemplateOutlet, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ComunicacionMenuService } from '../../../services/comunicacion-menu.service';
import { MenuService } from '../../../services/menu.service';

@Component({
  selector: 'app-sidebar-menu',
  templateUrl: './sidebar-menu.component.html',
  styleUrls: ['./sidebar-menu.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
  standalone: true,
  imports: [
    NgFor,
    NgClass,
    AngularSvgIconModule,
    NgTemplateOutlet,
    RouterLink,
    RouterLinkActive,
    NgIf,
    SidebarSubmenuComponent,
    FormsModule,
  ],
})
export class SidebarMenuComponent implements OnInit {

  constructor(public menuService: MenuService, public comunicacionMenu: ComunicacionMenuService) {}

  public toggleMenu(subMenu: SubMenuItem) {
    this.menuService.toggleMenu(subMenu);
  }

  selectedItem: string;

  selectFilter(item: SubMenuItem): void {
    this.selectedItem = item.label;
    //console.log('Item seleccionado: ', this.selectedItem);
    this.comunicacionMenu.triggerFocusSearchBar(); // Enfocar la barra de búsqueda
  }

  applyFilter() {
    console.log('Item seleccionado: ', this.selectedItem);
    const filterValue = this.selectedItem;
    let endpoint: string;

    switch (this.selectedItem) {
      case 'GIN':
        endpoint = `http://localhost:8080/empleado/${filterValue}`;
        console.log('He pillado ' + endpoint);
        break;
      case 'Nombre':
        endpoint = `http://localhost:8080/empleado/bench/${filterValue}`;
        console.log("He pillado "+endpoint);
        break;
      case 'Subgrupo':
        endpoint = `http://localhost:8080/empleado/ciudad/${filterValue}`;
        console.log("He pillado "+endpoint);
        break;
      case 'Status':
        endpoint = `http://localhost:8080/empleado/jornada/${filterValue}`;
        break;
      case 'Bench':
        endpoint = `http://localhost:8080/empleado/groups/${filterValue}`;
        break;
      case 'Das':
        endpoint = `http://localhost:8080/empleado/n4/${filterValue}`;
        break;
      case 'Ciudad':
        endpoint = `http://localhost:8080/empleado/categoria/${filterValue}`;
        break;
      case 'Line_manager':
        endpoint = `http://localhost:8080/empleado/scr/${filterValue}`;
        break;
      case 'Jornada':
        endpoint = `http://localhost:8080/empleado/job_technology_profile/${filterValue}`;
        break;
      case 'GCM':
        endpoint = `http://localhost:8080/empleado/sk_bussskill/bussskill/${filterValue}`;
        break;
      case 'Categoría':
        endpoint = `http://localhost:8080/empleado/sk_technology/technology/${filterValue}`;
        break;
      case 'NivelGCM':
        endpoint = `http://localhost:8080/empleado/sk_certif/certif/${filterValue}`;
        break;
      case 'SCR (+iud)':
        endpoint = `http://localhost:8080/empleado/skLenguage/${filterValue}`;
        break;
      case 'CC':
        endpoint = `http://localhost:8080/empleado/sk_methods/${filterValue}`;
        break;
      case 'CCName':
        endpoint = `http://localhost:8080/empleado/sk_techskills/${filterValue}`;
        break;
        case 'Grupo':
        endpoint = `http://localhost:8080/empleado/sk_techskills/${filterValue}`;
        break;
        case 'Agrupacion':
        endpoint = `http://localhost:8080/empleado/sk_techskills/${filterValue}`;
        break;
        case 'Job Technology':
        endpoint = `http://localhost:8080/empleado/sk_techskills/${filterValue}`;
        break;
        case 'Job Technology Profile':
        endpoint = `http://localhost:8080/empleado/sk_techskills/${filterValue}`;
        break;
        case 'Skills':
        endpoint = `http://localhost:8080/empleado/sk_techskills/${filterValue}`;
        break;
        case 'Role':
        endpoint = `http://localhost:8080/empleado/sk_techskills/${filterValue}`;
        break;

        default:
          console.error('No hay un endpoint válido para el elemento seleccionado.');
    }
    if (endpoint) {
      localStorage.setItem("_endpoint", endpoint);
      localStorage.setItem("_selectedItem", this.selectedItem);
    } else {
      console.error('Endpoint no definido.');
    }
  }

  ngOnInit(): void {}
}
