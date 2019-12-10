import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { skills } from '../skills';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { MentorDetailsService } from 'src/app/services/mentor-details.service';


@Component({
  selector: 'app-mentor-info',
  templateUrl: './mentor-info.component.html',
  styleUrls: ['./mentor-info.component.css']
})
export class MentorInfoComponent implements OnInit {
  @Input() mentor:skills;
  @Output() userId:EventEmitter<string> =new EventEmitter<string>();
  constructor(private authService:AuthenticationService,private mentorService:MentorDetailsService) { }

  ngOnInit() {
  }
  isStudent(){
    return this.authService.isStudent;
  }
  isMentor(){
    return this.authService.isMentor;
  }
  book(userName:String,technologyName:number){
    console.log( this.authService.username+" "+userName+"  "+technologyName);
    return this.mentorService.book(this.authService.username,userName,technologyName).subscribe((data)=>{
      console.log(data);
    })
  } 
}
