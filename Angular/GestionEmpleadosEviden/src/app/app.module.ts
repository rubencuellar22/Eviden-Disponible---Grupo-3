import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; 
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FiltersComponent } from './filters/filters.component';
import { FilteredTableComponent } from './filtered-table/filtered-table.component';
import { DetailsComponent } from './details/details.component';
import { FirstPageComponent } from './first-page/first-page.component';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    FiltersComponent,
    FilteredTableComponent,
    DetailsComponent,
    FirstPageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, // Asegúrate de incluir HttpClientModule aquí
    RouterModule,
    CommonModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
