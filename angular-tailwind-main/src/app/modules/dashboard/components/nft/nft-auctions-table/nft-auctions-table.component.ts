import { Component, OnInit } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common'; // Importa CommonModule y DatePipe
import { Nft } from '../../../models/nft';

@Component({
    selector: '[nft-auctions-table]',
    templateUrl: './nft-auctions-table.component.html',
    styleUrls: ['./nft-auctions-table.component.css'],
    standalone: true,
    imports: [CommonModule], // Agrega CommonModule a la lista de imports
    providers: [DatePipe] // Agrega DatePipe a la lista de providers
})
export class NftAuctionsTableComponent implements OnInit {
  public activeAuction: Nft[] = [];
  public empleados: any[] = []; // Define la propiedad empleados

  constructor() {
    // Inicializa los datos de empleados aquí si es necesario
  }

  ngOnInit(): void {}
}
