import { ChangeDetectionStrategy, Component, OnInit, ViewChild } from '@angular/core';
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
        FormsModule
    ],
})
export class SidebarMenuComponent implements OnInit {

  //@ViewChild(SearchBarComponent) searchBarComponent: SearchBarComponent; // Referenciar el SearchBarComponent
  
  constructor(public menuService: MenuService, public comunicacionMenu: ComunicacionMenuService) {}
  
  public toggleMenu(subMenu: SubMenuItem) {
    this.menuService.toggleMenu(subMenu);
  }

  selectedItem:string;
  
  selectFilter(item: any): void {
    this.selectedItem = item.label;
    console.log('Item seleccionado: ', this.selectedItem);
    this.comunicacionMenu.triggerFocusSearchBar(); // Enfocar la barra de búsqueda
  }

  ngOnInit(): void {}
}
