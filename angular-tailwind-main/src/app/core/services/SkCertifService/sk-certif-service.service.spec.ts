import { TestBed } from '@angular/core/testing';

import { SkCertifService } from './sk-certif-service.service';

describe('SkCertifService', () => {
  let service: SkCertifService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkCertifService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
