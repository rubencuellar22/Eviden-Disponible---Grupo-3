import { Component, Input, OnInit } from '@angular/core';
import { SubMenuItem } from 'src/app/core/models/menu.model';
import { MenuService } from '../../../services/menu.service';
import { AngularSvgIconModule } from 'angular-svg-icon';
import { RouterLinkActive, RouterLink } from '@angular/router';
import { NgClass, NgFor, NgTemplateOutlet } from '@angular/common';
import { ComunicacionMenuService } from '../../../services/comunicacion-menu.service';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-sidebar-submenu',
    templateUrl: './sidebar-submenu.component.html',
    styleUrls: ['./sidebar-submenu.component.scss'],
    standalone: true,
    imports: [
        NgClass,
        NgFor,
        NgTemplateOutlet,
        RouterLinkActive,
        RouterLink,
        AngularSvgIconModule,
        FormsModule
    ],
})
export class SidebarSubmenuComponent implements OnInit {
  @Input() public submenu = <SubMenuItem>{};

  constructor(public menuService: MenuService, public comunicacionMenu: ComunicacionMenuService) {}

  ngOnInit(): void {}

  subMenuItem:string;

  selectFilter(item: SubMenuItem): void {
    this.subMenuItem = item.label;
    console.log('Subitem seleccionado: ', this.subMenuItem);
    this.comunicacionMenu.triggerFocusSearchBar(); // Enfocar la barra de búsqueda
  }

  applyFilter() {
    console.log('Item seleccionado: ', this.subMenuItem);
    const filterValue = this.subMenuItem;
    let endpoint: string;

    switch (this.subMenuItem) {
      case 'A1':
          endpoint = `http://localhost:8080/empleado/skLenguage//{A1}`;
          break;
        case 'A2':
          endpoint = `http://localhost:8080/empleado/status/`;
          break;
        case 'B1':
          endpoint = `http://localhost:8080/empleado/status/`;
          break;
        case 'B2':
          endpoint = `http://localhost:8080/empleado/status/`;
          break;
        case 'C1':
          endpoint = `http://localhost:8080/empleado/status/`;
          break;
        case 'C2':
          endpoint = `http://localhost:8080/empleado/status/`;
          break;

          
  

        default:
          console.error('No hay un endpoint válido para el elemento seleccionado.');
    }
    if (endpoint) {
      localStorage.setItem("_endpoint", endpoint);
      localStorage.setItem("_selectedItem", this.subMenuItem);
    } else {
      console.error('Endpoint no definido.');
    }
  }

  public toggleMenu(menu: any) {
    this.menuService.toggleSubMenu(menu);
  }

  private collapse(items: Array<any>) {
    items.forEach((item) => {
      item.expanded = false;
      if (item.children) this.collapse(item.children);
    });
  }
}
