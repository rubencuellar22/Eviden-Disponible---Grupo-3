import { TestBed } from '@angular/core/testing';

import { EmpleadoStateService } from './empleado-state.service';

describe('EmpleadoStateService', () => {
  let service: EmpleadoStateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmpleadoStateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
