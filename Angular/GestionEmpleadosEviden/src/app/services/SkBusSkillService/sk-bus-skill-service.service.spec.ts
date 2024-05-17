import { TestBed } from '@angular/core/testing';

import { SkBusSkillServiceService } from './sk-bus-skill-service.service';

describe('SkBusSkillServiceService', () => {
  let service: SkBusSkillServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkBusSkillServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
