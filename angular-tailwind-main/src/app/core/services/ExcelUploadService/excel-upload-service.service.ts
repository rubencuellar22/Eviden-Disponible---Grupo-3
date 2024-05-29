import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExcelUploadServiceService {

  constructor(private http: HttpClient) { }

  uploadFile(file: File): Observable<string> {
    const formData = new FormData();
    formData.append('file', file);

    return this.http.post('http://localhost:8080/uploadFile', formData, {responseType: 'text'});
  }
}
