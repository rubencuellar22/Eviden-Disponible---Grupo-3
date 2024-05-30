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
  endpoint: string ="";

  @ViewChild('searchInput') searchInput: ElementRef;

  constructor(private menuService: MenuService, private comunicacionMenu: ComunicacionMenuService) {}

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
      this.endpoint = localStorage.getItem("_endpoint")
      console.log(this.endpoint);
    }
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
