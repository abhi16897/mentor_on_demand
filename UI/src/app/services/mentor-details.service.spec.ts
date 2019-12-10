import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { MentorDetailsService } from './mentor-details.service';

describe('MentorDetailsService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports:[HttpClientTestingModule]
  }));

  it('should be created', () => {
    const service: MentorDetailsService = TestBed.get(MentorDetailsService);
    expect(service).toBeTruthy();
  });
});
