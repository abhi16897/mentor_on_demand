import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MentorInfoComponent } from './mentor-info.component';
import { RouterTestingModule } from '@angular/router/testing';

describe('MentorInfoComponent', () => {
  let component: MentorInfoComponent;
  let fixture: ComponentFixture<MentorInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MentorInfoComponent ],
      imports:[RouterTestingModule],
      
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MentorInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
