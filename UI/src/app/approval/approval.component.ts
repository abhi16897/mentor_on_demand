import { Component, OnInit } from '@angular/core';
import { MentorDetailsService } from '../services/mentor-details.service';
import { AuthenticationService } from '../services/authentication.service';
import { Training } from './Training';


@Component({
  selector: 'app-approval',
  templateUrl: './approval.component.html',
  styleUrls: ['./approval.component.css']
})
export class ApprovalComponent implements OnInit {
  trainingList:Training
  constructor( private mentroDetails:MentorDetailsService,private authService:AuthenticationService) { }

  ngOnInit() {
      this.fetchdata();
  }
  approve(training:Training){
    this.mentroDetails.update(training.id,'A').subscribe((data)=>{
      console.log(data);
      this.fetchdata();
    })
  }
  deny(training:Training){
    this.mentroDetails.update(training.id,'D').subscribe((data)=>{
      console.log(data);
      this.fetchdata();
    })
  }
  fetchdata(){
    this.mentroDetails.getMentorRequests(this.authService.username,'P').subscribe((data)=>{
      this.trainingList=data;
    })
  }


}

