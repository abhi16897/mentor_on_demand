import { Component, OnInit } from '@angular/core';
import { Training } from '../approval/Training';
import { MentorDetailsService } from '../services/mentor-details.service';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-student-approval',
  templateUrl: './student-approval.component.html',
  styleUrls: ['./student-approval.component.css']
})
export class StudentApprovalComponent implements OnInit {
  trainingList:Training[];
  constructor(private mentorDetailService:MentorDetailsService,private authservice:AuthenticationService) { }

  ngOnInit() {
    this.fetchdata();
  }

  fetchdata(){
    this.mentorDetailService.getStudentRequests(this.authservice.username).subscribe((data)=>{
      this.trainingList=data;
      console.log(data);
    })
  }
}
