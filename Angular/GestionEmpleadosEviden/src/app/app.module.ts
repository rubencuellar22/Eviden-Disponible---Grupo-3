import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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
    RouterModule,
    CommonModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
