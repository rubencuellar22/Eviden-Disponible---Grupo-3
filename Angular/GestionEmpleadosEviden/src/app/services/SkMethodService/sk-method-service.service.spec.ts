import { TestBed } from '@angular/core/testing';

import { SkMethodServiceService } from './sk-method-service.service';

describe('SkMethodServiceService', () => {
  let service: SkMethodServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkMethodServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
