import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; 
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FiltersComponent } from './filters/filters.component';
import { FilteredTableComponent } from './filtered-table/filtered-table.component';
import { DetailsComponent } from './details/details.component';
import { FirstPageComponent } from './first-page/first-page.component';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LanguageLevelsComponent } from './language-levels/language-levels.component';
import { ProgrammingLevelsComponent } from './programming-levels/programming-levels.component';


@NgModule({
  declarations: [
    AppComponent,
    FiltersComponent,
    FilteredTableComponent,
    DetailsComponent,
    FirstPageComponent,
    LanguageLevelsComponent,
    ProgrammingLevelsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, // Asegúrate de incluir HttpClientModule aquí
    RouterModule,
    CommonModule,
    AppRoutingModule,
    FormsModule, 
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
