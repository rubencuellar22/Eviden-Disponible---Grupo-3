import { TestBed } from '@angular/core/testing';

import { JobTechnologyProfileService } from './job-technology-profile-service.service';

describe('JobTechnologyProfileServiceService', () => {
  let service: JobTechnologyProfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JobTechnologyProfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
