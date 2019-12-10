import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { RegistrationService } from './registration.service';

describe('RegistrationService', () => {
  let httpTestingController: HttpTestingController;
  let service: RegistrationService;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule]
    });
    httpTestingController = TestBed.get(HttpTestingController);
    service = TestBed.get(RegistrationService);
  });

  afterEach(() => {
    httpTestingController.verify();
  });
  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  describe('#addMentorDetails()', () => {
    it('Check the type of httpClient', () => {
      const mentorDetails = {
        userName: 'abhi',
        firstName: 'abhi',
        lastName: 'pabbisetty',
        email: 'abhi@cognizant.com',
        password: 'pwd',
        contact: '1234567893',
        linkedInUrl: 'ashdjkl',
        experience: 123,
        active: 'true',
    image:'asdjfhaklsdjgklsdjfljk'
      }
      service.addMentorDetails(mentorDetails).subscribe(mentor => {
        expect(mentor.userName).toEqual('abhi');

      })
      const req = httpTestingController.expectOne('http://localhost:9801/registration/mentor', 'post to api');
      expect(req.request.method).toEqual('POST');
      req.flush(mentorDetails);
      httpTestingController.verify();
    });
  });
  describe('#addStudentDetails()', () => {
    it('Check the type of httpClient', () => {
      const studentDetails = {
        userName: 'abhi',
        firstName: 'abhi',
        lastName: 'pabbisetty',
        email: 'abhi@cognizant.com',
        password: 'pwd',
        contact: '1234567893',
        active: 'true',
        image:'asdjfhaklsdjgklsdjfljk'
      }
      service.addStudentDetails(studentDetails).subscribe(mentor => {
        expect(mentor.userName).toEqual('abhi');
      })
      const req = httpTestingController.expectOne('http://localhost:9801/registration/student', 'post to api');
      expect(req.request.method).toEqual('POST');
      req.flush(studentDetails);
      httpTestingController.verify();
    });
  });
  describe('#addMentorSkills()', () => {
    it('Check the type of httpClient', () => {
      const mentorSkills = {
        skillName: 'Data Science',
        trainings: 12,
        facilities: 'Book',
        experience: 2,
        rating: 3
      }
      service.addMentorSkills(mentorSkills, 'mentor', 'Data Science').subscribe(mentor => {
        expect(mentor.trainings).toEqual(12);
      })
      const req = httpTestingController.expectOne('http://localhost:9801/registration/mentor/skills/mentor/Data Science', 'post to api');
      expect(req.request.method).toEqual('POST');
      req.flush(mentorSkills);
      httpTestingController.verify();
    });
  });


});

