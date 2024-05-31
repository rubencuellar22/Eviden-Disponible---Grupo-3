import { Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { Nft } from '../../../models/nft';
import { NgStyle, CurrencyPipe } from '@angular/common';
import { ExcelUploadServiceService } from 'src/app/core/services/ExcelUploadService/excel-upload-service.service';
import { EmpleadoService } from 'src/app/core/services/empleado-service.service';
import { EmpleadoStateService } from 'src/app/core/services/EmpleadosStateService/empleado-state.service';
import { switchMap } from 'rxjs';
import { Empleado } from 'src/app/core/models/empleado';
import { DataService } from 'src/app/app.service.import';


@Component({
    selector: '[nft-single-card]',
    templateUrl: './nft-single-card.component.html',
    standalone: true,
    imports: [NgStyle, CurrencyPipe],
})
export class NftSingleCardComponent implements OnInit {

  @Input() nft: Nft = <Nft>{};
  @ViewChild('dropzoneFile', { static: false }) dropzoneFile: ElementRef;
  @ViewChild('customText', { static: false }) customText: ElementRef;
  @ViewChild('dropzoneLabel', { static: false }) dropzoneLabel: ElementRef;
  @ViewChild('sendExcelElement', { static: false }) sendExcelElement: ElementRef;

  isLoading: boolean = false;

  toastOpenSuccess: boolean = false;
  toastOpenFailed: boolean = false;

  empleadosEmpty: boolean = true;

  constructor(private excelUploadService: ExcelUploadServiceService, private empleadoStateService: EmpleadoStateService, private dataService: DataService) {}

  ngOnInit(): void {
    this.empleadoStateService.showImportExcel$.subscribe((data: boolean) => {
      this.empleadosEmpty = data;
    });
  }

  handleDragOver($event: DragEvent) {
    $event.preventDefault();
    $event.stopPropagation();

    const dropzoneLabelElement = this.dropzoneLabel.nativeElement as HTMLElement;
    dropzoneLabelElement.style.backgroundColor = 'lightblue';
  }

  handleDragLeave($event: DragEvent) {
    $event.preventDefault();
    $event.stopPropagation();

    const dropzoneLabelElement = this.dropzoneLabel.nativeElement as HTMLElement;
    dropzoneLabelElement.style.backgroundColor = 'white';
  }

  handleFileSelect($event: Event) {
    if (this.dropzoneFile.nativeElement.files.length === 0) {
      this.customText.nativeElement.innerText = 'Ningún excel seleccionado';
      this.sendExcelElement.nativeElement.style.display = 'hidden';
      return;
    }
    this.customText.nativeElement.innerText = this.dropzoneFile.nativeElement.files[0].name;

    this.sendExcelElement.nativeElement.style.display = 'block';
  }

  handleFileDrop($event: DragEvent) {
    const dropzoneLabelElement = this.dropzoneLabel.nativeElement as HTMLElement;
    dropzoneLabelElement.style.backgroundColor = 'white';

    $event.preventDefault();
    $event.stopPropagation();

    if ($event.dataTransfer.files.length === 0
    || !$event.dataTransfer.files[0].name.endsWith(".xlsx")) {
      this.customText.nativeElement.innerText = 'Ningún excel seleccionado';
      this.sendExcelElement.nativeElement.style.display = 'hidden';
      return;
    }

    this.customText.nativeElement.innerText = $event.dataTransfer.files[0].name;

    this.sendExcelElement.nativeElement.style.display = 'block';

    this.dropzoneFile.nativeElement.files = $event.dataTransfer.files;
  }

  sendExcel() {
    console.log('Enviando excel');
    this.isLoading = true;
    var responseString: string;

    const file = this.dropzoneFile.nativeElement.files[0];
    console.log(file == null ? 'File is null' : 'File is not null');
    this.excelUploadService.uploadFile(file).subscribe({next : (response) => {
      console.log('File uploaded successfully');
      responseString = response;
      console.log(response);

      this.empleadoStateService.updateEmpleados();

      this.isLoading = false;

      this.toastOpenSuccess = true;

      setTimeout(() => {
        this.toastOpenSuccess = false;
      }, 2000);
      
      this.dataService. changeToExport();
    },
    error: (error) => {
      console.log('Error uploading file');
      console.log(error);
      this.isLoading = false;

      this.toastOpenFailed = true;

      setTimeout(() => {
        this.toastOpenFailed = false;
      }, 2000);
    }
  });
  }
}
