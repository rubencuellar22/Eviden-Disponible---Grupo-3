import { Component } from '@angular/core';
import { ThemeService } from './core/services/theme.service';
import { NgClass } from '@angular/common';
import { ResponsiveHelperComponent } from './shared/components/responsive-helper/responsive-helper.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  standalone: true,
  imports: [NgClass, RouterOutlet, ResponsiveHelperComponent],
})

export class AppComponent {
  title = 'Angular Tailwind';

  constructor(public themeService: ThemeService) {}
}

