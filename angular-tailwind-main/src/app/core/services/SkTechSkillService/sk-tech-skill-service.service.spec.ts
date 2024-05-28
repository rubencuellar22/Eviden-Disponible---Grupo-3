import { TestBed } from '@angular/core/testing';

import { SkTechSkillService } from './sk-tech-skill-service.service';

describe('SkTechSkillService', () => {
  let service: SkTechSkillService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkTechSkillService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
