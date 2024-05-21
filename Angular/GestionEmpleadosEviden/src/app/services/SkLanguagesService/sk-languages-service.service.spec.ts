import { TestBed } from '@angular/core/testing';

import { SkLanguagesServiceService } from './sk-languages-service.service';

describe('SkLanguagesServiceService', () => {
  let service: SkLanguagesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkLanguagesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
