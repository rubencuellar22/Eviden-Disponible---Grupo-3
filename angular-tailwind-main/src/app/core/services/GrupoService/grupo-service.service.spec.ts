import { TestBed } from '@angular/core/testing';

import { GrupoService } from './grupo-service.service';

describe('GrupoServiceService', () => {
  let service: GrupoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GrupoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
