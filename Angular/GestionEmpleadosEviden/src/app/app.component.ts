import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'GestionEmpleadosEviden';
  buttonText = 'Details'; // Texto por defecto del botón
  buttonRoute = 'details'; // Ruta por defecto del botón

  constructor(private router: Router) {}

  ngOnInit() {
    // Suscribirse al evento de cambio de ruta
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Verificar la ruta actual y actualizar el texto del botón y su ruta según corresponda
        this.updateButton();
      }
    });
  }

  updateButton() {
    const currentUrl = this.router.url;
    // Determinar el texto y la ruta del botón según la ruta actual
    if (currentUrl === '/landing') {
      this.buttonText = 'Details';
      this.buttonRoute = 'details';
    } else if (currentUrl === '/details') {
      this.buttonText = 'Back';
      this.buttonRoute = 'landing';
    } else {
      this.buttonText = 'Details'; // Texto por defecto para otras páginas
      this.buttonRoute = 'landing';
    }
  }

  navigateToButtonRoute() {
    this.router.navigate([this.buttonRoute]);
  }
}