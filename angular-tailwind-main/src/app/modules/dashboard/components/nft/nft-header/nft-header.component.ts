import { Component, OnInit } from '@angular/core';
import { EmpleadoStateService } from 'src/app/core/services/EmpleadosStateService/empleado-state.service';

@Component({
    selector: 'app-nft-header',
    templateUrl: './nft-header.component.html',
    standalone: true,
})
export class NftHeaderComponent implements OnInit {
  constructor(private empleadoStateService: EmpleadoStateService) {}

  ngOnInit(): void {}

  toggleShowImportExcel() {
    this.empleadoStateService.toggleShowImportExcel();
  }
}
