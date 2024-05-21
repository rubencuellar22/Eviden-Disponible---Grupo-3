import { Component } from '@angular/core';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent {
  tags: string[] = [];
  newTag: string = '';

  showChild1: boolean = true; 

  removeTag(tag: string) {
    this.tags = this.tags.filter(t => t !== tag);
  }

  addTag() {
    if (this.newTag && !this.tags.includes(this.newTag)) {
      this.tags.push(this.newTag);
      this.newTag = ''; // Limpiar el input después de agregar el tag
    }
  }
}
