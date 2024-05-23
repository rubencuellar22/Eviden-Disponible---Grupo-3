import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgrammingLevelsComponent } from './programming-levels.component';

describe('ProgrammingLevelsComponent', () => {
  let component: ProgrammingLevelsComponent;
  let fixture: ComponentFixture<ProgrammingLevelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProgrammingLevelsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProgrammingLevelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
