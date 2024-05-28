import { TestBed } from '@angular/core/testing';

import { SkMethodService } from './sk-method-service.service';

describe('SkMethodServiceService', () => {
  let service: SkMethodService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkMethodService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
