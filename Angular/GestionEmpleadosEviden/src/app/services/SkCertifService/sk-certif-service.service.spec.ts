import { TestBed } from '@angular/core/testing';

import { SkCertifServiceService } from './sk-certif-service.service';

describe('SkCertifServiceService', () => {
  let service: SkCertifServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkCertifServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
