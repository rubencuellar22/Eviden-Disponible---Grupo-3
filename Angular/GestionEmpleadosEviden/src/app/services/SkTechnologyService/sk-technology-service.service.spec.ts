import { TestBed } from '@angular/core/testing';

import { SkTechnologyServiceService } from './sk-technology-service.service';

describe('SkTechnologyServiceService', () => {
  let service: SkTechnologyServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkTechnologyServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
