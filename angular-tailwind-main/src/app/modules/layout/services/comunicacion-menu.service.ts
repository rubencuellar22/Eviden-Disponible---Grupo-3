import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComunicacionMenuService {

  private focusSearchBarSubject = new Subject<void>();
  
  focusSearchBar$ = this.focusSearchBarSubject.asObservable();

  toggleMenu(subMenu: any) {
    // Lógica existente
  }

  triggerFocusSearchBar() {
    this.focusSearchBarSubject.next();
  }
}
