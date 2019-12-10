import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorProgressComponent } from './mentor-progress.component';

describe('MentorProgressComponent', () => {
  let component: MentorProgressComponent;
  let fixture: ComponentFixture<MentorProgressComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorProgressComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorProgressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
