import { TestBed } from '@angular/core/testing';

import { SkTechnologyService } from './sk-technology-service.service';

describe('SkTechnologyService', () => {
  let service: SkTechnologyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkTechnologyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
