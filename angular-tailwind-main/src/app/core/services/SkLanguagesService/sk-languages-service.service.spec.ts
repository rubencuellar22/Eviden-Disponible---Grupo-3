import { TestBed } from '@angular/core/testing';

import { SkLanguagesService } from './sk-languages-service.service';

describe('SkLanguagesServiceService', () => {
  let service: SkLanguagesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkLanguagesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
