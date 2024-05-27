import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JobTechnologyProfile } from '../../classes/JobTechnologyProfile/job-technology-profile';

@Injectable({
  providedIn: 'root'
})
export class JobTechnologyProfileService {
  private apiUrl = 'http://localhost:8080/empleado/job_technology_profile/jobtechnologyprofile';

  constructor(private http: HttpClient) {}

  getJobTechnologyProfiles(): Observable<JobTechnologyProfile[]> {
    return this.http.get<JobTechnologyProfile[]>(this.apiUrl);
  }

  getJobTechnologyProfileById(id: number): Observable<JobTechnologyProfile> {
    return this.http.get<JobTechnologyProfile>(`${this.apiUrl}/${id}`);
  }

  // createJobTechnologyProfile(jobTechnologyProfile: JobTechnologyProfile): Observable<JobTechnologyProfile> {
  //   return this.http.post<JobTechnologyProfile>(this.apiUrl, jobTechnologyProfile);
  // }

  // updateJobTechnologyProfile(id: number, jobTechnologyProfile: JobTechnologyProfile): Observable<JobTechnologyProfile> {
  //   return this.http.put<JobTechnologyProfile>(`${this.apiUrl}/${id}`, jobTechnologyProfile);
  // }

  // deleteJobTechnologyProfile(id: number): Observable<void> {
  //   return this.http.delete<void>(`${this.apiUrl}/${id}`);
  // }
}