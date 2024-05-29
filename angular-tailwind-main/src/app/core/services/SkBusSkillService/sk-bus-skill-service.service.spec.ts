import { TestBed } from '@angular/core/testing';

import { SkBusSkillService } from './sk-bus-skill-service.service';

describe('SkBusSkillService', () => {
  let service: SkBusSkillService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkBusSkillService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
