import { TestBed } from '@angular/core/testing';

import { SkTechSkillServiceService } from './sk-tech-skill-service.service';

describe('SkTechSkillServiceService', () => {
  let service: SkTechSkillServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SkTechSkillServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
